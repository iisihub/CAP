package com.iisigroup.cap.auth.service.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

import com.iisigroup.cap.auth.dao.UserDao;
import com.iisigroup.cap.auth.dao.PwdLogDao;
import com.iisigroup.cap.auth.model.User;
import com.iisigroup.cap.auth.model.PwdLog;
import com.iisigroup.cap.base.dao.CodeTypeDao;
import com.iisigroup.cap.base.model.CodeType;
import com.iisigroup.cap.base.model.SysParm;
import com.iisigroup.cap.dao.ICommonDao;
import com.iisigroup.cap.exception.CapMessageException;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.security.SecConstants.PwdPloicyKeys;
import com.iisigroup.cap.security.service.IPasswordService;
import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapDate;

@Service
public class PasswordServiceImpl implements IPasswordService {

    @Resource
    private UserDao userDao;
    @Resource
    private ICommonDao commonDao;
    @Resource
    private PwdLogDao userPwdHistoryDao;
    @Resource
    private CodeTypeDao codeTypeDao;

    @Override
    public boolean checkPasswordRule(String userId, String password, String password2, boolean forcePwdChange) {
        SysParm parmPwdRule = commonDao.findById(SysParm.class, PwdPloicyKeys.PWD_RULE.toString().toLowerCase());
        SysParm parmPwdMinLen = commonDao.findById(SysParm.class, PwdPloicyKeys.PWD_MIN_LENGTH.toString().toLowerCase());
        SysParm parmPwdMaxHistory = commonDao.findById(SysParm.class, PwdPloicyKeys.PWD_MAX_HISTORY.toString().toLowerCase());
        SysParm parmPwdChangeInteval = commonDao.findById(SysParm.class, PwdPloicyKeys.PWD_CHANGE_INTERVAL.toString().toLowerCase());
        int minLen = Integer.parseInt(parmPwdMinLen.getParmValue());
        int maxHistory = Integer.parseInt(parmPwdMaxHistory.getParmValue());
        int changeInteval = Integer.parseInt(parmPwdChangeInteval.getParmValue());
        String ruleType = parmPwdRule.getParmValue();
        CodeType rule = codeTypeDao.findByCodeTypeAndCodeValue("pwdrule", ruleType, CapSecurityContext.getLocale().toString());
        if (StringUtils.isBlank(password) || StringUtils.isBlank(password2)) {
            throw new CapMessageException(CapAppContext.getMessage("error.001", new Object[] {}), getClass());
        }
        if (!password.equals(password2) || password.length() < minLen) {
            throw new CapMessageException(CapAppContext.getMessage("error.002", new Object[] { minLen }), getClass());
        }
        if (userId.equalsIgnoreCase(password)) {
            throw new CapMessageException(CapAppContext.getMessage("error.004", new Object[] { minLen }), getClass());
        }
        // pwd history validate
        User user = userDao.findByCode(userId);
        if (user != null) {
            List<PwdLog> list = userPwdHistoryDao.findByUserCode(user.getOid(), maxHistory);
            int i = 0;
            PasswordEncoder passwordEncoder = new StandardPasswordEncoder(userId);
            for (PwdLog h : list) {
                // user status 不為 1 時，check change interval: 最近一次變更不得小於間隔
                if (i == 0 && !"1".equals(user.getStatus()) && !forcePwdChange) {
                    if (CapDate.calculateDays(Calendar.getInstance().getTime(), h.getUpdateTime()) <= changeInteval) {
                        throw new CapMessageException(CapAppContext.getMessage("error.005", new Object[] { changeInteval }), getClass());
                    }
                }
                if (passwordEncoder.matches(password, h.getPassword())) {
                    throw new CapMessageException(CapAppContext.getMessage("error.003", new Object[] { maxHistory }), getClass());
                }
                i++;
            }
        }
        String pattern = null;
        switch (Integer.parseInt(ruleType)) {
        case 1:
            pattern = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{" + minLen + ",}$";
            break;
        case 2:
            pattern = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&()_-])(?=\\S+$).{" + minLen + ",}$";
            break;
        case 3:
            pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{" + minLen + ",}$";
            break;
        case 4:
            pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&()_-])(?=\\S+$).{" + minLen + ",}$";
            break;
        }
        if (pattern != null && !password.matches(pattern)) {
            throw new CapMessageException(CapAppContext.getMessage("error.008", new Object[] { rule.getCodeDesc() }), getClass());
        }
        return true;
    }// ;

    @Override
    public boolean validatePassword(String userId, String password) {
        User user = userDao.findByCode(userId);
        PasswordEncoder passwordEncoder = new StandardPasswordEncoder(userId);
        return passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    public void changeUserPassword(String userId, String password) {
        SysParm parmPwdExpiredDay = commonDao.findById(SysParm.class, PwdPloicyKeys.PWD_EXPIRED_DAY.toString().toLowerCase());
        int expiredDay = Integer.parseInt(parmPwdExpiredDay.getParmValue());
        Date now = Calendar.getInstance().getTime();
        User user = userDao.findByCode(userId);
        String pwdHash = encodePassword(user.getCode(), password);
        user.setPwdExpiredTime(new Timestamp(CapDate.shiftDays(now, expiredDay).getTime()));
        user.setPassword(pwdHash);
        user.setStatus("0");
        userDao.save(user);
        // insert pwd history
        PwdLog uph = new PwdLog();
        uph.setUserCode(user.getCode());
        uph.setPassword(pwdHash);
        uph.setUpdateTime(new Timestamp(now.getTime()));
        userPwdHistoryDao.save(uph);
    }

    @Override
    public Map<String, String> getPasswordPolicy() {
        Map<String, String> result = new HashMap<String, String>();
        for (PwdPloicyKeys value : PwdPloicyKeys.values()) {
            SysParm parm = commonDao.findById(SysParm.class, value.toString().toLowerCase());
            if (parm != null) {
                result.put(parm.getParmId(), parm.getParmValue());
            }
        }
        return result;
    }

    private String encodePassword(String userId, String password) {
        StandardPasswordEncoder spe = new StandardPasswordEncoder(userId);
        return spe.encode(password);
    }

    @Override
    public int getPasswordChangeNotifyDay(String userId) {
        SysParm parmPwdExpiredDay = commonDao.findById(SysParm.class, PwdPloicyKeys.PWD_EXPIRED_DAY.toString().toLowerCase());
        SysParm parmPwdNotifyDay = commonDao.findById(SysParm.class, PwdPloicyKeys.PWD_NOTIFY_DAY.toString().toLowerCase());
        int notifyDay = Integer.parseInt(parmPwdNotifyDay.getParmValue());
        int expiredDay = Integer.parseInt(parmPwdExpiredDay.getParmValue());
        User user = userDao.findByCode(userId);
        List<PwdLog> list = userPwdHistoryDao.findByUserCode(user.getOid(), 1);
        for (PwdLog h : list) {
            int diff = CapDate.calculateDays(Calendar.getInstance().getTime(), h.getUpdateTime());
            if (diff >= (expiredDay - notifyDay)) {
                return (expiredDay - diff);
            }
        }
        return -1;
    }

}
