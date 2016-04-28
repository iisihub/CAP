/*
 * CapConstants.java
 *
 * Copyright (c) 2009 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System, Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
 */
package com.iisigroup.cap;

/**
 * <p>
 * This Drools provide common use constants..
 * </p>
 * 
 * @author TimChiang
 * @version
 *          <ul>
 *          <li>2013/12/27,TimChiang,new
 *          </ul>
 */
public interface DroolsConstants {

    /**
     * 
     */
    public final static String PACKAGE_NAME = "com.iisigroup.cap.service";

    public final static String IMPORT_CLASS = "com.iisigroup.cap.rule.model.CaseInfo,com.iisigroup.cap.utils.CapDroolsUtil";

    public final static String VARIABLES_NAME = "com.iisigroup.cap.utils.CapDroolsUtil comUtil";

    public final static String CONDITION_COL = "CONDITION";

    public final static String ACTION_COL = "ACTION";

    public final static String ACTIVATION_GROUP = "ACTIVATION-GROUP";

    public final static String NO_LOOP = "NO-LOOP";

    public final static String PRIORITY = "PRIORITY";
}
