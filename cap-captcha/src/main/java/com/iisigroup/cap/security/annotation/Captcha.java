/* 
 * Captcha.java
 * 
 * Copyright (c) 2009-2014 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.security.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <pre>
 * 動態驗証碼
 * </pre>
 * 
 * @since 2013/3/27
 * @author rodeschen
 * @version <ul>
 *          <li>2013/3/27,rodeschen,new
 *          </ul>
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Captcha {
	String value() default "captcha";
}
