/* 
 * CapXmlUtil.java
 * 
 * Copyright (c) 2009-2013 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.utils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.apache.commons.lang.CharEncoding;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iisigroup.cap.Constants;
import com.iisigroup.cap.exception.CapException;
import com.iisigroup.cap.exception.CapMessageException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * <pre>
 * Cap XML document util
 * </pre>
 * 
 * @since 2013/1/8
 * @author rodeschen
 * @version
 *          <ul>
 *          <li>2013/1/8,rodeschen,new
 *          </ul>
 */
public class CapXmlUtil {
    protected static final Logger logger = LoggerFactory.getLogger(CapXmlUtil.class);

    /**
     * 取得 xPath 節點 text
     * 
     * @param document
     *            xmlDocument
     * @param xPath
     *            xpath
     * @return String
     */
    public static String getDocSingleNodeTextByXPath(Document document, String xPath) {
        try {
            Node node = document.selectSingleNode(xPath);
            if (node != null) {
                return node.getText();
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 將XML字串轉換為JSON
     * 
     * @param xmlString
     *            xmlString
     * @return jsonObject
     */
    public static JSONObject convertXmlStringToJson(String xmlString) {
        try {
            Document document = DocumentHelper.parseText(xmlString);
            Element root = document.getRootElement();
            return travelXML(root);
        } catch (DocumentException e) {
            throw new CapMessageException(e, CapXmlUtil.class);
        }
    }

    /**
     * 將 XML 字串轉為Document
     * 
     * @param xmlString
     *            xmlString
     * @return Document
     * @throws CapException
     */
    public static Document convertXMLStringToDocument(String xmlString) {
        try {
            return DocumentHelper.parseText(xmlString);
        } catch (DocumentException e) {
            throw new CapMessageException(e, CapXmlUtil.class);
        }
    }

    /**
     * 將xml document 轉換為 string
     * 
     * @param doc
     *            document
     * @param format
     *            format
     * @return String
     */
    public static String convertDocumentToString(Document doc, boolean format) {
        StringWriter out = new StringWriter();
        try {
            new XMLWriter(out, new OutputFormat(Constants.EMPTY_STRING, format, CharEncoding.UTF_8)).write(doc);
            return out.toString();
        } catch (IOException e) {
            throw new CapMessageException(e, CapXmlUtil.class);
        }
    }

    /**
     * 將xml document 轉換為 string
     * 
     * @param doc
     *            document
     * @return String
     */
    public static String convertDocumentToString(Document doc) {
        return convertDocumentToString(doc, false);
    }

    @SuppressWarnings("unchecked")
    private static JSONObject travelXML(Element el) {
        JSONObject json = new JSONObject();
        String nodeName = el.getName();
        if (el.elements().isEmpty()) {
            putJSONValue(json, nodeName, el.getTextTrim());
        } else {
            JSONObject json2 = new JSONObject();
            for (Element el2 : (List<Element>) el.elements()) {
                putJSONValue(json2, el2.getName(), travelXML(el2).get(el2.getName()));
            }
            putJSONValue(json, nodeName, json2);
        }
        return json;
    }

    private static void putJSONValue(JSONObject json, String key, Object value) {
        if (json.containsKey(key)) {
            Object j = json.get(key);
            if (j instanceof JSONArray) {
                ((JSONArray) j).add(value);
            } else {
                JSONArray ja = new JSONArray();
                ja.add(j);
                ja.add(value);
                json.put(key, ja);
            }
        } else {
            json.put(key, value);
        }

    }

}
