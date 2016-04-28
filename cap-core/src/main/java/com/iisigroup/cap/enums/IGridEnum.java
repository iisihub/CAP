/**
 * IGridEnum.java
 *
 * Copyright (c) 2009 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System,Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
*/
package com.iisigroup.cap.enums;

/**
 * <p>
 * IGridEnum
 * </p>
 * 
 * <pre>
 * $Date: 2010-08-03 17:38:52 +0800 (星期二, 03 八月 2010) $
 * $Author: iris $
 * $Revision: 26 $
 * $HeadURL: svn://192.168.0.1/MICB_ISDOC/cap/cap-core/src/main/java/tw/com/iisi/cap/enums/IGridEnum.java $
 * </pre>
 *
 * @author iristu
 * @version $Revision: 26 $
 * @version
 *          <ul>
 *          <li>2010/7/16,iristu,new
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
public enum IGridEnum {
    PAGE("page"),
    PAGEROWS("rows"),
    TOTAL("total"),
    RECORDS("records"),
    SORTTYPE("sord"),
    SORTASC("asc"),
    SORTDESC("desc"),
    SORTCOLUMN("sidx"),
    CELL("cell"),
    COL_NAME("name"),
    COL_INDEX("index"),
    COL_PARAM("_columnParam");

    private String code;

    IGridEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
