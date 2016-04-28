package com.iisigroup.cap.mvc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * <pre>
 * Base Action Controller
 * </pre>
 * 
 * @since 2011/11/1
 * @author rodeschen
 * @version
 *          <ul>
 *          <li>2011/11/1,rodeschen,new
 *          </ul>
 */
public class BaseActionController extends MultiActionController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public static final String SUCCESS_VIEW = "success";

    /**
     * json 回传写入
     * 
     * @param response
     *            response
     * @param string
     *            json String
     */
    protected void outputString(HttpServletResponse response, String contentType, String string) {
        // response.setContentType("text/xml;charset=UTF-8");
        response.setContentType(contentType);
        try {
            response.setContentLength(string.getBytes("UTF-8").length);
        } catch (UnsupportedEncodingException e1) {
            response.setContentLength(string.getBytes().length);
            logger.error(e1.getMessage(), e1);
        }
        try {
            PrintWriter out = response.getWriter();
            out.write(string);
            out.flush();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    private static String CONTENT_TYPE_JSON = "text/plain;charset=UTF-8";

    /**
     * json 回传写入
     * 
     * @param response
     *            response
     * @param str
     *            str
     */
    protected void outJsonString(HttpServletResponse response, String str) {
        outputString(response, CONTENT_TYPE_JSON, str);
    }

    private static String CONTENT_TYPE_XML = "text/xml;charset=UTF-8";

    /**
     * xml 回传写入
     * 
     * @param response
     *            response
     * @param str
     *            str
     */
    protected void outXmlString(HttpServletResponse response, String str) {
        outputString(response, CONTENT_TYPE_XML, str);
    }
}