/* 
 * SessionLocaleResolver.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.mvc.Interceptor;

import java.util.Locale;

/**
 * <pre>
 * TODO Write a short description on the purpose of the program
 * </pre>
 * 
 * @since 2012/2/29
 * @author rodeschen
 * @version <ul>
 *          <li>2012/2/29,rodeschen,new
 *          </ul>
 */
public class SessionLocaleResolver extends org.springframework.web.servlet.i18n.SessionLocaleResolver {

    @Override
    public void setDefaultLocale(Locale defaultLocale) {
        Locale.setDefault(defaultLocale);
        super.setDefaultLocale(defaultLocale);
    }

}
