/* 
 * CapSqlUtil.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.utils;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterUtils;

/**
 * <pre>
 * CapSqlUtil
 * </pre>
 * 
 * @since 2012/9/21
 * @author iristu
 * @version <ul>
 *          <li>2012/9/21,iristu,new
 *          </ul>
 */
public class CapDbUtil {

	private static final Logger logger = LoggerFactory
			.getLogger(CapDbUtil.class);

	static final String EMPTY_STRING = "";

	/**
	 * <pre>
	 * trim全形空白
	 * </pre>
	 * 
	 * @param in
	 *            the input
	 * @return String
	 */
	public static String trimFullSpace(String in) {
		if (in == null) {
			return "";
		}
		return in.replaceAll("^[　 ]+", "").replaceAll("[　 ]+$", "");
	}// ;

	/**
	 * trimNull 當傳入值為Null時，則回傳空字串。不為Null時，則回傳trim過的String
	 * 
	 * @param o
	 *            the input
	 * @return string
	 */
	public static String trimNull(Object o) {
		if (o != null && !"".equals(o)) {
			return (o.toString()).trim();
		} else {
			return EMPTY_STRING;
		}
	}// ;

	/**
	 * Convert a prepared statment to standard SQL command Can be used to debug
	 * SQL command
	 * 
	 * @param cmd
	 *            the sql
	 * @param data
	 *            the parameters
	 * @return String
	 */
	public static String convertToSQLCommand(String cmd,
			Map<String, Object> data) {
		String sql = NamedParameterUtils.parseSqlStatementIntoString(cmd);
		if (data == null || data.isEmpty())
			return cmd;
		Object[] oa = NamedParameterUtils.buildValueArray(cmd, data);
		StringBuffer sb = new StringBuffer(sql);
		try {
			int[] npos = getQuestionPos(sb, oa.length);
			for (int j = npos.length - 1; j >= 0; j--) {
				if (npos[j] > 0) {
					int pos = npos[j];
					String value = getSqlValue(oa[j]);
					sb.deleteCharAt(pos);
					sb.insert(pos, value == null ? "null" : "'" + value + "'");
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			logger.error(e.getMessage());
		}
		return sb.toString();
	}// ;

	/**
	 * Message Format
	 * 
	 * String pattern = "An ${key1} a day keeps the ${key2} away!"; Map<String,
	 * Map<String, Object> params = {key1=Apple,key2=doctor} new
	 * 
	 * return An Apple a day keep the doctor away!
	 */
	@Deprecated
	public static String messageFormat(String pattern,
			Map<String, Object> params) {
		final StringBuffer buffer = new StringBuffer();
		// For each occurrences of "${"
		int start;
		int pos = 0;

		while ((start = pattern.indexOf("${", pos)) != -1) {
			buffer.append(pattern.substring(pos, start));
			if (pattern.charAt(start + 1) == '$') {
				buffer.append("$");
				pos = start + 2;
				continue;
			}
			pos = start;
			final int startVariableName = start + 2;
			final int endVariableName = pattern.indexOf('}', startVariableName);

			if (endVariableName != -1) {
				String variableName = pattern.substring(startVariableName,
						endVariableName);
				String value = params.containsKey(variableName) ? params.get(
						variableName).toString() : "";
				buffer.append(value);
				pos = endVariableName + 1;
			} else {
				break;
			}
		}
		if (pos < pattern.length()) {
			buffer.append(pattern.substring(pos));
		}
		return buffer.toString();
	}// ;

	/**
	 * use Spring Expression Language (SpEL) parse
	 * 
	 * @param expressionStr
	 *            expression string
	 * @param params
	 * @param parserContext
	 * @return
	 */
	public static String spelParser(String expressionStr,
			Map<String, Object> params, ParserContext parserContext) {
		StandardEvaluationContext context = new StandardEvaluationContext(
				params);
		ExpressionParser spel = new SpelExpressionParser();
		return spel.parseExpression(expressionStr, parserContext).getValue(
				context, String.class);
	}// ;

	@SuppressWarnings("rawtypes")
	protected static String getSqlValue(Object o) {
		String rtn = null;
		if (o == null) {
			rtn = null;
		} else {
			if (o instanceof String) {
				rtn = (String) o;
			} else if (o instanceof Number || o instanceof BigDecimal) {
				rtn = o.toString();
			} else if (o instanceof Timestamp) {
				rtn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSS")
						.format(o);
			} else if (o instanceof Time) {
				rtn = new SimpleDateFormat("HH:mm:ss").format(o);
			} else if (o instanceof Date) {
				rtn = new SimpleDateFormat("yyyy-MM-dd").format(o);
			} else if (o instanceof Collection) {
				rtn = getSqlValue(((Collection) o).toArray());
			} else if (o.getClass().isArray()) {
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < Array.getLength(o); ++i) {
					sb.append(i == 0 ? "" : "'").append(Array.get(o, i))
							.append("',");
				}
				sb.deleteCharAt(sb.length() - 1);
				sb.deleteCharAt(sb.length() - 1);
				rtn = sb.toString();
			} else {
				rtn = "?";
			}
		}
		return rtn;
	}// ;

	/**
	 * getQuestionPos
	 * 
	 * @param sb
	 *            StringBuffer
	 * @param len
	 *            len
	 * @return int[]
	 */
	protected static int[] getQuestionPos(StringBuffer sb, int len) {
		int[] pos = new int[len];
		int npos = 0;
		int i = 0;
		do {
			npos = sb.indexOf("?", npos);
			pos[i] = npos;
			i++;
			npos++;
		} while (npos > 0 && i < pos.length);
		return pos;
	}// ;

}
