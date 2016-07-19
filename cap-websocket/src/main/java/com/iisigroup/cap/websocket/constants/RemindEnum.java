package com.iisigroup.cap.websocket.constants;

/**
 * <pre>
 * remind styleTyp status enum
 * </pre>
 * 
 * @since 2014/1/28
 * @author tammy
 * @version
 *          <ul>
 *          <li>2014/1/28,tammy,new
 *          </ul>
 */
public enum RemindEnum {

    TEXT("0"), // 0.文字
    POPUP("1"), // 1.彈出對話框
    MAIL("2"); // 2.電子郵件

    private String code;

    RemindEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
