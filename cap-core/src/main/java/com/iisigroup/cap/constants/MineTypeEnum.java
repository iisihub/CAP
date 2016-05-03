/*
 * MineTypeEnum.java
 *
 * Copyright (c) 2009-2012 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System,Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
 */
package com.iisigroup.cap.constants;

/**
 * <pre>
 * MineType Enum
 * </pre>
 * 
 * @since 2011/11/23
 * @author rodeschen
 * @version
 *          <ul>
 *          <li>2011/11/23,rodeschen,new
 *          </ul>
 */
public enum MineTypeEnum {
    JSON("text/plain"),
    TEXT("text/plain");

    private String code;

    MineTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
