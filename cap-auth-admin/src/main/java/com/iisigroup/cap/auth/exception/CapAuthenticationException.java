package com.iisigroup.cap.auth.exception;

import org.springframework.security.core.AuthenticationException;

@SuppressWarnings("serial")
public class CapAuthenticationException extends AuthenticationException {

    private boolean captchaEnabled;

    private boolean forceChangePwd;

    private boolean askChangePwd;

    public CapAuthenticationException(String msg) {
        this(msg, false, false);
    }

    public CapAuthenticationException(String msg, boolean captchaEnabled) {
        this(msg, captchaEnabled, false);
    }

    public CapAuthenticationException(String msg, boolean captchaEnabled, boolean forceChangePwd) {
        this(msg, captchaEnabled, forceChangePwd, false);
    }

    public CapAuthenticationException(String msg, boolean captchaEnabled, boolean forceChangePwd, boolean askChangePwd) {
        super(msg);
        this.captchaEnabled = captchaEnabled;
        this.forceChangePwd = forceChangePwd;
        this.askChangePwd = askChangePwd;
    }

    public boolean isCaptchaEnabled() {
        return captchaEnabled;
    }

    public void setCaptchaEnabled(boolean captchaEnabled) {
        this.captchaEnabled = captchaEnabled;
    }

    public boolean isForceChangePwd() {
        return forceChangePwd;
    }

    public void setforceChangePwd(boolean forceChangePwd) {
        this.forceChangePwd = forceChangePwd;
    }

    public boolean isAskChangePwd() {
        return askChangePwd;
    }

    public void setAskChangePwd(boolean askChangePwd) {
        this.askChangePwd = askChangePwd;
    }
}
