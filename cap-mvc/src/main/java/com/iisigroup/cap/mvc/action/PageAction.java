package com.iisigroup.cap.mvc.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.security.model.CapUserDetails;

/**
 * <pre>
 * page action
 * </pre>
 * 
 * @since 2011-11-29
 * @author mars
 * @version <ul>
 *          <li>2011-11-29,mars,new
 *          <li>2013/3/8,RodesChen, add append userDetails
 *          </ul>
 */
@Controller
@RequestMapping("/*")
public class PageAction extends BaseActionController {

	@RequestMapping("/error")
	public ModelAndView error(Locale locale, HttpServletRequest request,
			HttpServletResponse response) {
		String path = request.getPathInfo();
		ModelAndView model = new ModelAndView(path);
		HttpSession session = request.getSession(false);
		final AuthenticationException ae = (session != null) ? (AuthenticationException) session
				.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION) : null;
		if (ae != null) {
			String errmsg = ae.getMessage();
			model.addObject("errorMessage", errmsg);
		}
		return model;
	}

	@RequestMapping("/**")
	public ModelAndView handleRequestInternal(Locale locale,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String path = request.getPathInfo();
		ModelAndView model = new ModelAndView(path);
		CapUserDetails userDetails = CapSecurityContext.getUser();
		if (userDetails != null) {
			model.addObject("userDetails", userDetails);
		}
		return model;
	}
}
