package com.iisigroup.cap.utils;
/* 
 * CapFileUtils.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */

import java.io.File;

/**
 * <pre>
 * FileUtils
 * </pre>
 * 
 * @since 2016/8/29
 * @author Sunkist
 * @version
 *          <ul>
 *          <li>2016/8/29,sunkist,new
 *          </ul>
 */
public class CapFileUtils {

    /**
     * 判斷檔案目錄是否合法
     * 
     * @param filePath
     *            上層檔案路徑
     * @param filename
     *            檔名
     * @return 合法的路徑，不合法回傳null
     */
    public static String getValidPath(String baseDirPath, String filename) {
        if (baseDirPath.indexOf('.') >= 0) {
            return null;
        }

        filename = getValidFilename(filename);
        if (filename == null) {
            return null;
        }

        return baseDirPath + File.separator + filename;
    }

    /**
     * 判斷檔案目錄是否合法
     * 
     * @param filename
     *            檔案路徑
     * @return 合法的路徑，不合法回傳null
     */
    public static String getValidFilename(String filename) {

        String clearPath = removeSpecialCharacters(filename);
        if (clearPath == null) {
            return null;
        }

        if (!filename.equals(clearPath)) {
            return null;
        }

        return filename;
    }

    public static String removeSpecialCharacters(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("\\\\|/|;|\\+", "");
    }
}
