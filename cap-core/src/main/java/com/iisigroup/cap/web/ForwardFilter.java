package com.iisigroup.cap.web;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * CapForwardFilter
 * </pre>
 * 
 * @since 2011/3/10
 * @author iristu
 * @version <ul>
 *          <li>2011/3/10,iristu,new
 *          <li>2011/3/22,RodesChen,修改filter方式
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
public class ForwardFilter implements Filter {

    Map<String, String> filterRules;

    /**
     * <pre>
     * init
     * </pre>
     * 
     * @param filterConfig
     *            FilterConfig
     * @throws ServletException
     */
    @SuppressWarnings("unchecked")
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        filterRules = new LinkedHashMap<String, String>();
        Enumeration<String> filter = filterConfig.getInitParameterNames();
        String rule = null;
        while (filter.hasMoreElements()) {
            rule = filter.nextElement();
            filterRules.put(rule, filterConfig.getInitParameter(rule));
        }
    }

    /**
     * <pre>
     * 當url路徑符合filterPath時，則直接導到正確的路徑
     * </pre>
     * 
     * @param request
     *            ServletRequest
     * @param response
     *            ServletResponse
     * @param chain
     *            FilterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = ((HttpServletRequest) request);
        String url = req.getRequestURL().toString();
        Iterator<String> rules = filterRules.keySet().iterator();
        String filterPath = null, distPath = null;
        boolean forward = false;
        while (rules.hasNext()) {
            filterPath = rules.next();
            distPath = filterRules.get(filterPath);
            if (CapString.checkRegularMatch(url, filterPath)) {
                forward = true;
                if (CapString.checkRegularMatch(filterPath, "(\\*|\\+|\\?)$")) {
                    url = CapString.getRegularMatch(url, "(?<=" + filterPath.replaceAll("(\\*|\\.|\\*)$", "") + ").*");
                    forwardToPage((HttpServletRequest) request, (HttpServletResponse) response, distPath + "/" + url.replaceAll("^/", ""));
                } else {
                    forwardToPage((HttpServletRequest) request, (HttpServletResponse) response, distPath);
                }
                break;
            }
        }
        if (!forward) {
            chain.doFilter(request, response);
        }

    }

    /**
     * <pre>
     * destroy
     * </pre>
     */
    @Override
    public void destroy() {
        // do nothing
    }

    private void forwardToPage(HttpServletRequest request, HttpServletResponse response, String page) throws IOException, ServletException {
        RequestDispatcher dispatch = request.getRequestDispatcher(page);
        dispatch.forward(request, response);
    }

}
