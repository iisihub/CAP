package com.iisigroup.cap.security.provider;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import com.iisigroup.cap.security.SecConstants.PwdPloicyKeys;
import com.iisigroup.cap.security.captcha.CapSecurityCaptcha;
import com.iisigroup.cap.security.captcha.CapSecurityCaptcha.CaptchaStatus;
import com.iisigroup.cap.security.captcha.servlet.CapCaptchaServlet;
import com.iisigroup.cap.security.exception.CapAuthenticationException;
import com.iisigroup.cap.security.filter.CaptchaCaptureFilter;
import com.iisigroup.cap.security.model.CapUserDetails;
import com.iisigroup.cap.security.service.IAccessControlService;
import com.iisigroup.cap.security.service.IPasswordService;
import com.iisigroup.cap.utils.CapAppContext;

public class CapAuthenticationProvider implements AuthenticationProvider {

    private UserDetailsService userService;
    private IPasswordService passwordService;
    private IAccessControlService accessControlService;
    private Logger logger = LoggerFactory.getLogger(CapAuthenticationProvider.class);
    private CaptchaCaptureFilter captchaCaptureFilter;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = String.valueOf(authentication.getPrincipal());
        String password = String.valueOf(authentication.getCredentials());
        logger.debug("Checking authentication for user {}", username);
        logger.debug("userResponse: {}", captchaCaptureFilter.getUserCaptchaResponse());
        boolean captchaEnabled = isCaptchaEnabled();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new CapAuthenticationException("No Username and/or Password Provided.", captchaEnabled);
        } else if (captchaEnabled && StringUtils.isBlank(captchaCaptureFilter.getUserCaptchaResponse())) {
            throw new CapAuthenticationException("Captcha Response is Empty", captchaEnabled);
        } else {
            Map<String, String> policy = passwordService.getPasswordPolicy();
            boolean captchaPassed = true;
            boolean forceChangePwd = isForceChangePwd(username);
            Integer wrongCount = getWrountCount(username);
            logger.debug("wrongCount-{}: {}", username, wrongCount);
            // 密碼連錯 PWD_ACCOUNT_LOCK 次 lock user
            if (wrongCount >= Integer.parseInt(policy.get(PwdPloicyKeys.PWD_ACCOUNT_LOCK.toString().toLowerCase()))) {
                accessControlService.lockUserByUserId(username);
                throw new CapAuthenticationException("User locked.", captchaEnabled);
            }
            // 驗證 captcha
            if (captchaEnabled) {
                String cpatchaData = captchaCaptureFilter.getRequest().getParameter("captcha");
                CapSecurityCaptcha captcha = CapAppContext.getBean(CapCaptchaServlet.DEF_RENDERER);
                captchaPassed = CaptchaStatus.SUCCESS.equals(captcha.valid(cpatchaData));
                logger.debug("Is captcha valid: " + captchaPassed);
            } else {
                captchaPassed = true;
            }
            if (captchaPassed) {
                resetCaptchaFields();
                CapUserDetails user;
                try {
                    user = (CapUserDetails) userService.loadUserByUsername(username);
                } catch (Exception e) {
                    throw new CapAuthenticationException(e.getMessage(), captchaEnabled, forceChangePwd);
                }
                boolean currentPwdVerified = verifyPassword(username, authentication.getCredentials().toString(), user.getPassword());
                if (currentPwdVerified) {
                    setWrountCount(username, 0);
                    String authedPwd = checkStatus(user, username, password, policy, captchaEnabled, forceChangePwd);
                    // 登入成功
                    setForceChangePwd(username, false);
                    // 檢核是否要提醒使用者變更密碼
                    notifyPasswordChange(username, captchaEnabled, forceChangePwd);
                    accessControlService.login(username);
                    return new UsernamePasswordAuthenticationToken(user, authedPwd, user.getAuthorities());
                } else {
                    setWrountCount(username, getWrountCount(username) + 1);
                    // 連錯 N 次，enable captcha
                    if (wrongCount >= Integer.parseInt(policy.get(PwdPloicyKeys.PWD_CAPTCHA_ENABLE.toString().toLowerCase()))) {
                        setCaptchaEnabled(true);
                    }
                    throw new CapAuthenticationException("Invalid Password.", isCaptchaEnabled(), forceChangePwd);
                }
            } else {
                logger.debug("Captcha is invalid!");
                resetCaptchaFields();
                throw new CapAuthenticationException("Invalid Captcha.", captchaEnabled, forceChangePwd);
            }
        }
    }

    private String checkStatus(CapUserDetails user, String username, String password, Map<String, String> policy, boolean captchaEnabled, boolean forceChangePwd) {
        String authedPwd = "";
        int status = StringUtils.isBlank(user.getStatus()) ? -1 : Integer.parseInt(user.getStatus());
        switch (status) {
        case 0:// 正常
            authedPwd = password;
            break;
        case 1:// 初始
               // 若「首次登入是否強制更換密碼」為1，則強制更換密碼，否則用原密碼登入。
            if ("1".equals(policy.get(PwdPloicyKeys.PWD_FORCE_CHANGE_PWD.toString().toLowerCase()))) {
                authedPwd = forceChangePassword(username, captchaEnabled, forceChangePwd, CapAppContext.getMessage("error.011"));
            } else {
                authedPwd = password;
            }
            break;
        case 2: // 禁用
            throw new CapAuthenticationException(CapAppContext.getMessage("error.006", new Object[] { username }), captchaEnabled, forceChangePwd);
        case 3: // 密碼過期
            authedPwd = forceChangePassword(username, captchaEnabled, forceChangePwd, CapAppContext.getMessage("error.012"));
            break;
        case 9: // 刪除
            throw new CapAuthenticationException(CapAppContext.getMessage("error.007", new Object[] { username }), captchaEnabled, forceChangePwd);
        default:
            throw new CapAuthenticationException("Invalid User Status.", captchaEnabled, forceChangePwd);
        }
        String agreeChange = captchaCaptureFilter.getRequest().getParameter("agreeChange");
        if (Boolean.valueOf(agreeChange)) {
            authedPwd = forceChangePassword(username, captchaEnabled, forceChangePwd, "");
        }
        return authedPwd;
    }

    private void notifyPasswordChange(String userId, boolean captchaEnabled, boolean forceChangePwd) {
        String ignoreNotify = captchaCaptureFilter.getRequest().getParameter("ignoreNotify");
        if (!Boolean.valueOf(ignoreNotify)) {
            int diff = passwordService.getPasswordChangeNotifyDay(userId) + 1;
            if (diff > 0) {
                throw new CapAuthenticationException(CapAppContext.getMessage("error.013", new Object[] { diff }), captchaEnabled, forceChangePwd, true);
            }
        }
    }

    private String forceChangePassword(String username, boolean captchaEnabled, boolean forceChangePwd, String reason) {
        String newPwd = captchaCaptureFilter.getRequest().getParameter("newPwd");
        String confirm = captchaCaptureFilter.getRequest().getParameter("confirm");
        if (StringUtils.isBlank(newPwd) || StringUtils.isBlank(confirm)) {
            setForceChangePwd(username, true);
            throw new CapAuthenticationException(reason + CapAppContext.getMessage("error.010"), captchaEnabled, true);
        } else {
            // set new password
            try {
                passwordService.checkPasswordRule(username, newPwd, confirm, true);
            } catch (Exception e) {
                throw new CapAuthenticationException(e.getMessage(), captchaEnabled, forceChangePwd);
            }
            passwordService.changeUserPassword(username, newPwd);
            return newPwd;
        }
    }

    private boolean verifyPassword(String username, String presentedPassword, String encodedPassword) {
        PasswordEncoder passwordEncoder = new StandardPasswordEncoder(username);
        if (passwordEncoder.matches(presentedPassword, encodedPassword)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

    public void resetCaptchaFields() {
        captchaCaptureFilter.setUserCaptchaResponse(null);
    }

    public CaptchaCaptureFilter getCaptchaCaptureFilter() {
        return captchaCaptureFilter;
    }

    public void setCaptchaCaptureFilter(CaptchaCaptureFilter captchaCaptureFilter) {
        this.captchaCaptureFilter = captchaCaptureFilter;
    }

    public UserDetailsService getUserService() {
        return userService;
    }

    public void setUserService(UserDetailsService userService) {
        this.userService = userService;
    }

    public IPasswordService getPasswordService() {
        return passwordService;
    }

    public void setPasswordService(IPasswordService passwordService) {
        this.passwordService = passwordService;
    }

    private boolean isForceChangePwd(String username) {
        HttpSession session = captchaCaptureFilter.getRequest().getSession();
        if (session.getAttribute("forceChangePwd-" + username) == null) {
            session.setAttribute("forceChangePwd-" + username, false);
        }
        return (Boolean) session.getAttribute("forceChangePwd-" + username);
    }

    private void setForceChangePwd(String username, boolean forceChangePwd) {
        HttpSession session = captchaCaptureFilter.getRequest().getSession();
        session.setAttribute("forceChangePwd-" + username, forceChangePwd);
    }

    private int getWrountCount(String username) {
        HttpSession session = captchaCaptureFilter.getRequest().getSession();
        if (session.getAttribute("wrongCount-" + username) == null) {
            session.setAttribute("wrongCount-" + username, 0);
        }
        return (Integer) session.getAttribute("wrongCount-" + username);
    }

    private void setWrountCount(String username, int count) {
        HttpSession session = captchaCaptureFilter.getRequest().getSession();
        session.setAttribute("wrongCount-" + username, count);
    }

    private boolean isCaptchaEnabled() {
        HttpSession session = captchaCaptureFilter.getRequest().getSession();
        return session.getAttribute("captchaEnabled") == null ? false : (Boolean) session.getAttribute("captchaEnabled");
    }

    private void setCaptchaEnabled(boolean captchaEnabled) {
        HttpSession session = captchaCaptureFilter.getRequest().getSession();
        session.setAttribute("captchaEnabled", captchaEnabled);
    }

    public IAccessControlService getAccessControlService() {
        return accessControlService;
    }

    public void setAccessControlService(IAccessControlService accessControlService) {
        this.accessControlService = accessControlService;
    }

}
