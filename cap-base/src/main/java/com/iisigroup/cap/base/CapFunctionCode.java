/* 
 * FunctionCode.java
 * 
 * Copyright (c) 2009-2013 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.base;

/**
 * <pre>
 * 本系統的功能列表
 * </pre>
 * 
 * @since 2013/11/1
 * @author Sunkist Wang
 * @version <ul>
 *          <li>2013/11/1,Sunkist Wang,new
 *          </ul>
 * @see CCMenuHandler
 */
public enum CapFunctionCode {

    /**
     * FunctionCode 100
     */
    F100("100", "system"),
    /**
     * FunctionCode 101;
     */
    F101("101", "codeType"),
    /**
     * FunctionCode 102;
     */
    F102("102", "sysParm");

    private CapFunctionCode(String code) {
        this.code = code;
    }

    private CapFunctionCode(String code, String urlPath) {
        this.code = code;
        this.urlPath = urlPath;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    private String code;
    private String urlPath;

    public String getCode() {
        return this.code;
    }

    public String toString() {
        return this.code;
    }

    public boolean isEquals(Object other) {
        if (other instanceof String) {
            return code.equals(other);
        } else {
            return super.equals(other);
        }
    }

    public static CapFunctionCode getEnum(String code) {
        for (CapFunctionCode enums : CapFunctionCode.values()) {
            if (enums.getCode().equals(code)) {
                return enums;
            }
        }
        return null;
    }

}
