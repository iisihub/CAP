package com.iisigroup.cap.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import com.iisigroup.cap.security.CapSecurityContext;

public class CaptchaCaptureFilter extends OncePerRequestFilter {

    private Logger logger = LoggerFactory.getLogger(CaptchaCaptureFilter.class);

    public void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        logger.debug("Captcha capture filter");

        // Assign values only when user has submitted a Captcha value.
        // Without this condition the values will be reset due to redirection
        // and CaptchaVerifierFilter will enter an infinite loop

        synchronized (req) {
            if (req.getParameter("captcha") != null) {
                CapSecurityContext.getUser().put("request", req);
            }
            logger.debug("userResponse: " + req.getParameter("captcha"));
        }

        // Proceed with the remaining filters
        chain.doFilter(req, res);
    }

}
