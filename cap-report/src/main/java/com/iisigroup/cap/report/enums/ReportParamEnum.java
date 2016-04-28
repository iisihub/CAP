package com.iisigroup.cap.report.enums;

/**
 * <pre>
 * param enum
 * </pre>
 * 
 * @since 2014/4/1
 * @author tammy
 * @version
 *          <ul>
 *          <li>2014/4/1,tammy,new
 *          </ul>
 */
public enum ReportParamEnum {
    templateName("templateName"),
    defaultEncoding("defaultEncoding"),
    encrypt("encryptPassword"),
    defaultFont("defaultFont");

    private String code;

    ReportParamEnum(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
