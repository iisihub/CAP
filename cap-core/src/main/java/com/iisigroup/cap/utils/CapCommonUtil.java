/*
 * Copyright (c) 2009-2012 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System, Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
 */
package com.iisigroup.cap.utils;

import java.util.Map;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * <pre>
 * CapCommonUtil
 * </pre>
 * 
 * @since 2010/12/29
 * @author RodesChen
 * @version
 *          <ul>
 *          <li>2010/12/29,RodesChen,new
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
public class CapCommonUtil {

    /**
     * use Spring Expression Language (SpEL) parse
     * 
     * @param expressionStr
     *            expression string
     * @param params
     *            parameters
     * @param parserContext
     *            parserContext
     * @return String
     */
    public static String spelParser(String expressionStr, Map<String, Object> params, ParserContext parserContext) {
        StandardEvaluationContext context = new StandardEvaluationContext(params);
        ExpressionParser spel = new SpelExpressionParser();
        return spel.parseExpression(expressionStr, parserContext).getValue(context, String.class);
    }

    final static ParserContext defParser = new TemplateParserContext();

    /**
     * use Spring Expression Language (SpEL) parse
     * 
     * @param expressionStr
     *            expression string
     * @param params
     *            parameters
     * @return String
     */
    public static String spelParser(String expressionStr, Map<String, Object> params) {
        return spelParser(expressionStr, params, defParser);
    }

}
