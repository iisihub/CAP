/**
 * 
 * <br>
 * Copyright: Copyright (c) 2001-2008<br>
 * Company: IISI
 * CrateDate: 2013/1/26 
 * @author gverds
 */
package com.iisigroup.cap.mvc.filter;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iisigroup.cap.utils.CapString;

/**
 * @author TimChiang
 * @since <li>2013/1/26,Tim,弱點掃描CrossSiteScript Filter <li>2014/3/21,tammy,copy
 *        to citi, 過濾字元
 *        <li>2014/4/7,Tim,copy to CAP
 */
public class XSSRequestWrapper extends HttpServletRequestWrapper {

	private static final Logger logger = LoggerFactory
			.getLogger(XSSRequestWrapper.class);

	public XSSRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	/**
	 * override getParameter方法，將參數名和參數值都做xss過濾。<br/>
	 * 如果需要取得原始的值，則通過super.getParameterValues(name)來獲取<br/>
	 * getParameterNames,getParameterValues和getParameterMap也可能需要override
	 */
	@Override
	public String getParameter(String name) {
		return xssEncode(super.getParameter(name));
	}

	@Override
	public String[] getParameterValues(String parameter) {
		String[] values = super.getParameterValues(parameter);
		if (values == null) {
			return null;
		}
		int count = values.length;
		String[] encodedValues = new String[count];
		for (int i = 0; i < count; i++) {
			encodedValues[i] = xssEncode(values[i]);
		}

		return encodedValues;
	}

	/**
	 * override getHeader方法，將參數名和參數值都做xss過濾。<br/>
	 * 如果需要取得原始的值，則通過super.getHeaders(name)來取得<br/>
	 * getHeaderNames 也可能需要override
	 */
	@Override
	public String getHeader(String name) {
		String value = super.getHeader(name);
		if (value != null) {
			value = xssEncode(value);
		}
		return value;
	}

	/**
	 * 將容易引起xss漏洞的濾掉字元並轉換
	 * 
	 * @param s
	 * @return String
	 */
	private static String xssEncode(String s) {
		if (CapString.isEmpty(s)) {
			return s;
		}
		try {
			s = URLDecoder.decode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
		}

		StringWriter writer = new StringWriter();
		// 配合underscore的unescape
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '&':
				writer.write("&amp;");
				break;
			case '<':
				writer.write("&lt;");
				break;
			case '>':
				writer.write("&gt;");
				break;
			case '\"':
				writer.write("&quot;");
				break;
			case '\'':
				writer.write("&#x27;");
				break;
			case '/':
				writer.write("&#x2F;");
				break;
			case '(':
				writer.write("&#40;");
				break;
			case ')':
				writer.write("&#41;");
				break;
			default:
				writer.write(c);
				break;
			}
		}
		return writer.toString();
	}
}
