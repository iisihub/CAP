/* 
 * DBExecuteAdvice.java
 * 
 * Copyright (c) 2009-2013 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * <pre>
 * DB 執行時間
 * </pre>
 * 
 * @since 2013/7/15
 * @author rodeschen
 * @version <ul>
 *          <li>2013/7/15,rodeschen,new
 *          </ul>
 */
@Aspect
public class DBExecuteAdvice {
	private static final Logger logger = LoggerFactory.getLogger(DBExecuteAdvice.class);
	
	
	@Around("execution(* com..dao.*.*(..))")
	public Object spendTime(ProceedingJoinPoint pjp) throws Throwable {
		String targetName = pjp.getStaticPart().toShortString();
		long start = System.currentTimeMillis();
		Object obj = pjp.proceed();
		long end = System.currentTimeMillis();
		logger.debug("DB execute time: " + (end - start) + "ms - " + targetName);
		return obj;

	}
}
