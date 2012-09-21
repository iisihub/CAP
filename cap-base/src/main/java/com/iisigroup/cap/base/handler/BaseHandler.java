package com.iisigroup.cap.base.handler;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import com.iisigroup.cap.Constants;
import com.iisigroup.cap.annotation.HandlerType;
import com.iisigroup.cap.annotation.HandlerType.HandlerTypeEnum;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.handler.MFormHandler;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.response.IResult;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.utils.CapAppContext;

/**
 * <pre>
 * base Handler
 * </pre>
 * 
 * @since 2011/11/28
 * @author rodeschen
 * @version <ul>
 *          <li>2011/11/28,rodeschen,new
 *          <li>2012/8/23,RodesChen,add default locale
 *          </ul>
 */
@Scope("request")
@Controller("basehandler")
public class BaseHandler extends MFormHandler {

	/**
	 * <pre>
	 * 檔案作業完成後以防IE status bar 不停止
	 * </pre>
	 * 
	 * @param params
	 *            PageParameters
	 * @return IResult
	 * @throws CapException
	 */
	public IResult fileSuccess(IRequest params) throws CapException {
		return new AjaxFormResult();
	}

	@HandlerType(HandlerTypeEnum.FORM)
	public IResult queryJsI18N(IRequest request) throws CapException {
		Properties prop = new Properties();
		AjaxFormResult result = new AjaxFormResult();
		Locale locale = null;
		try {
			locale = CapSecurityContext.getLocale();
			if (locale == null) {
				locale = Locale.getDefault();
			}
		} catch (Exception e) {
			locale = Locale.getDefault();
		}
		String i18nFile = null;
		try {
			i18nFile = new StringBuffer("classpath:/i18n/")
					.append(request.get("f").replaceAll("/?webroot/page", ""))
					.append("_").append(locale.toString())
					.append(".properties").toString();
			prop.load(CapAppContext.getApplicationContext()
					.getResource(i18nFile).getInputStream());
			for (Entry<Object, Object> entry : prop.entrySet()) {
				result.set((String) entry.getKey(), (String) entry.getValue());
			}
		} catch (Exception e) {
			logger.error("can't load " + i18nFile, e);
			// throw new CapException(e, getClass());
		}
		return result;
	}// ;

	@HandlerType(HandlerTypeEnum.FileUpload)
	public IResult upload(IRequest request) throws CapException {
		AjaxFormResult result = new AjaxFormResult();
		String str = request.get("testStr");
		MultipartFile f = request.getFile("ufile");
		try {
			FileUtils.writeByteArrayToFile(new File("xxxx.txt"), f.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fileName = f.getOriginalFilename();
		result.set(Constants.AJAX_NOTIFY_MESSAGE, fileName
				+ " upload file success!!");
		return result;
	}// ;

}
