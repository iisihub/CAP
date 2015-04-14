package com.iisigroup.cap.security.handler;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.iisigroup.cap.security.exception.CapAuthenticationException;

@Component("ajaxAuthenticationFailureHandler")
public class AjaxAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        boolean capchaEnabled = ((CapAuthenticationException) exception).isCaptchaEnabled();
        boolean forceChangePwd = ((CapAuthenticationException) exception).isForceChangePwd();
        boolean askChangePwd = ((CapAuthenticationException) exception).isAskChangePwd();
        JSONObject o = new JSONObject();
        o.put("capchaEnabled", capchaEnabled);
        o.put("forceChangePwd", forceChangePwd);
        o.put("askChangePwd", askChangePwd);
        o.put("msg", exception.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, URLEncoder.encode(o.toString(), "utf-8").replaceAll("\\+", "%20"));
    }

}
