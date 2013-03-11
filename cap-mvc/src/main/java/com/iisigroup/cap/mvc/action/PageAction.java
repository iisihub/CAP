package com.iisigroup.cap.mvc.action;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.component.CapSpringMVCRequest;
import com.iisigroup.cap.mvc.page.report.IPageReport;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.security.model.CapUserDetails;
import com.iisigroup.cap.utils.CapAppContext;

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

	// @RequestMapping("/loginCheck")
	// public RedirectView loginCheck(Locale locale, HttpServletRequest request,
	// HttpServletResponse response) {
	// // CapUserDetails user = new BQDUserDetails();
	// // // String password = request.getParameter("password");
	// // user.setUserId(request.getParameter("id"));
	// // user.setLocale(locale);
	// // request.getSession().setAttribute(CapLogContextFilter.LOGIN_USERNAME,
	// user.getUserId());
	// // BQDSecurityContext.getSecurityContext().setUser(user);
	// // return new RedirectView("home");
	// }

	private IRequest getDefaultRequest() {
		IRequest cr = CapAppContext.getBean("CapDefaultRequest");
		return cr != null ? cr : new CapSpringMVCRequest();
	}

	@RequestMapping("/logout")
	public RedirectView logout(Locale locale, HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().invalidate();
		return new RedirectView("/");
	}

	@RequestMapping("/report/{reportService}")
	public ModelAndView handleReport(@PathVariable String reportService, Locale locale,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = request.getPathInfo();
		ModelAndView model = new ModelAndView(path);
		Map<String, Object> datas = new HashMap<String, Object>();
		IPageReport service = CapAppContext.getBean(reportService);
		if (service != null) {
			IRequest capRequest = getDefaultRequest();
			capRequest.setRequestObject(request);
			datas = service.excute(capRequest);
		}
		model.addAllObjects(datas);
		return model;
	}

	@RequestMapping("/**")
	public ModelAndView handleRequestInternal(Locale locale, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String path = request.getPathInfo();
		ModelAndView model = new ModelAndView(path);
		CapUserDetails userDetails = CapSecurityContext.getUser();
		if (userDetails != null) {
			model.addObject("userDetails", userDetails);
		}
		return model;
	}
}
