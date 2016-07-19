/* 
 * CaptchaStatus.java
 * 
 * Copyright (c) 2016 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.security.constants;

import java.util.EnumSet;

/**
 * <pre>
 * TODO Write a short description on the purpose of the program
 * </pre>
 * 
 * @since 2016年6月13日
 * @author Sunkist Wang
 * @version
 *          <ul>
 *          <li>2016年6月13日,Sunkist Wang,new
 *          </ul>
 */
public enum CheckStatus {
    // 成功
    SUCCESS("01"),
    // 失敗
    FAIL("02"),
    // 超時
    TIMEOUT("03");

    private String code;

    CheckStatus(String code) {
        this.code = code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static CheckStatus getByCode(String code) {
        CheckStatus returnValue = null;
        for (final CheckStatus element : EnumSet.allOf(CheckStatus.class)) {
            if (element.getCode().equals(code)) {
                returnValue = element;
                break;
            }
        }
        return returnValue;
    }
}
