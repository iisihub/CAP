/* 
 * ItextFontFactory.java
 * 
 * Copyright (c) 2009-2013 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.report.factory;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.iisigroup.cap.utils.CapAppContext;
import com.iisigroup.cap.utils.CapString;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;

/**
 * <pre>
 * FreeMarker report of page report
 * </pre>
 * 
 * @since 2014/2/13
 * @author tammy
 * @version
 *          <ul>
 *          <li>2014/2/13,tammy,new
 *          </ul>
 */
@Service
public class ItextFontFactory {

    protected final Logger logger = LoggerFactory.getLogger(ItextFontFactory.class);

    private String basePath;

    /**
     * @param basePath
     *            the basePath to set
     */
    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getBasePath() {
        return this.basePath;
    }

    public Font getFont(String fontname, String fontType, String encoding, boolean embedded, float size, int style, BaseColor color) {
        try {
            return FontFactory.getFont(getFontPath(fontname, fontType), encoding, embedded, size, style, color);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return new Font();
    }

    public Font getFont(String fontname, String fontType, String encoding, boolean embedded, float size) {
        return getFont(fontname, fontType, encoding, embedded, size, Font.UNDEFINED, null);
    }

    public String getFontPath(String fontname, String fontType) throws IOException {
        return CapAppContext.getResource(basePath + fontname).getURI().getPath() + (CapString.isEmpty(fontType) ? "" : "," + fontType);
    }

}
