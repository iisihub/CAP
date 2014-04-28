package com.iisigroup.cap.security.exception;

import org.springframework.security.core.AuthenticationException;

@SuppressWarnings("serial")
public class CapAuthenticationException extends AuthenticationException {

    private boolean captchaEnabled;

    private boolean firstLogin;

    public CapAuthenticationException(String msg) {
        this(msg, false, false);
    }

    public CapAuthenticationException(String msg, boolean captchaEnabled) {
        this(msg, captchaEnabled, false);
    }

    public CapAuthenticationException(String msg, boolean captchaEnabled,
            boolean firstLogin) {
        super(msg);
        this.captchaEnabled = captchaEnabled;
        this.firstLogin = firstLogin;
    }

    public boolean isCaptchaEnabled() {
        return captchaEnabled;
    }

    public void setCaptchaEnabled(boolean captchaEnabled) {
        this.captchaEnabled = captchaEnabled;
    }

    public boolean isFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }
}
