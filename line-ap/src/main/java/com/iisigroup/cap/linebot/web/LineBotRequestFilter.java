/* 
 * LineBotRequestFilter.java
 * 
 * Copyright (c) 2016 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.linebot.web;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iisigroup.cap.linebot.client.LineResource;
import com.linecorp.bot.client.LineBotAPIHeaders;
import com.linecorp.bot.client.exception.LineBotAPIException;

/**
 * <pre>
 * TODO Write a short description on the purpose of the program
 * </pre>
 * 
 * @since 2016年7月21日
 * @author Lancelot
 * @version
 *          <ul>
 *          <li>2016年7月21日,Lancelot,new
 *          </ul>
 */
public class LineBotRequestFilter implements Filter {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String signature = req.getHeader(LineBotAPIHeaders.X_LINE_CHANNEL_SIGNATURE);
        // for test
        // String dummyReq =
        // "{\"result\":[{\"content\":{\"toType\":1,\"createdTime\":1469088009354,\"from\":\"u7864630bc83a3308ab529e55f9142d5b\",\"location\":null,\"id\":\"4639897076146\",\"to\":[\"uf4d14d3d43b707adf996a6bd6b581118\"],\"text\":\"A123456789\",\"contentMetadata\":{\"AT_RECV_MODE\":\"2\",\"SKIP_BADGE_COUNT\":\"true\"},\"deliveredTime\":0,\"contentType\":1,\"seq\":null},\"createdTime\":1469088009382,\"eventType\":\"138311609000106303\",\"from\":\"u206d25c2ea6bd87c17655609a1c37cb8\",\"fromChannel\":1341301815,\"id\":\"WB1519-3658724674\",\"to\":[\"uf4d14d3d43b707adf996a6bd6b581118\"],\"toChannel\":1461968250}]}";
        // request.setAttribute("lineBot", dummyReq);
        // chain.doFilter(request, response);
        if (signature != null && signature.length() != 0) {
            final byte[] json = IOUtils.toByteArray(req.getInputStream());
            String lineReq = new String(json, StandardCharsets.UTF_8);
            if (logger.isDebugEnabled()) {
                logger.debug("got: {}", lineReq);
            }
            try {
                if (!LineResource.getLineBotClient().validateSignature(json, signature)) {
                    sendError(resp, "Invalid API signature");
                    return;
                } else {
                    request.setAttribute("lineBot", lineReq);
                    chain.doFilter(request, response);
                }
            } catch (LineBotAPIException e) {
                logger.warn("Invalid API signature", e);
                sendError(resp, "Internal serve error: " + e.getMessage());
                return;
            }
        } else {
            // 不是 Line Bot request
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    private void sendError(HttpServletResponse resp, String message) throws IOException {
        logger.warn(message);
        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, message);
        resp.setContentType("text/plain; charset=utf-8");
        resp.getWriter().write(message);
    }
}
