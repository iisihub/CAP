package com.iisigroup.cap.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

/**
 * <pre>
 * TODO Write a short description on the purpose of the program
 * </pre>
 * 
 * @since 2011/9/20
 * @author UFO
 * @version
 *          <ul>
 *          <li>2011/9/20,UFO,new
 *          </ul>
 */
public class StrUtils {

    /**
     * 取得組合字串
     * 
     * @param params
     *            字串片斷
     * @return 組合字串
     */
    public final static String concat(Object... params) {
        StringBuffer strBuf = new StringBuffer();
        for (Object o : params) {
            if (o instanceof byte[]) {
                strBuf.append(new String((byte[]) o));
            } else {
                strBuf.append(String.valueOf(o));
            }
        }
        return strBuf.toString();
    }

    /**
     * convert InputStream to String
     * 
     * @param is
     *            InputStream object
     * @return String
     */
    public static String stream2String(InputStream is) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line = null;
            while ((line = reader.readLine()) != null) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(line);
            }
        } catch (Exception ex) {
            sb.append("<<Exception>>:" + ex.getLocalizedMessage());
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * dump exception stacktrace to string
     * 
     * @param throwableObj
     *            Throwable object
     * @return stacktrace string
     */
    public static String getStackTrace(Throwable throwableObj) {
        if (throwableObj == null) {
            return "null";
        }
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        throwableObj.printStackTrace(printWriter);
        return result.toString();
    }

    /**
     * 依指定長度分割字串
     * 
     * @param str
     *            原始字串
     * @param len
     *            指定長
     * @return 分割後字串陣列
     */
    public static String[] splitFixedLength(String str, final int len) {
        // return str.split("(?<=\\G.{" + len + "})");
        List<String> tempList = new ArrayList<String>();
        int idx = 0;
        byte[] bmsg = str.getBytes();
        int blen = bmsg.length;
        while (idx < blen) {
            String tmp = new String(bmsg, idx, idx + len < blen ? len : blen - idx);
            tempList.add(tmp);
            idx += len;

        }
        return tempList.toArray(new String[tempList.size()]);
    }

    /**
     * 在指定長度的字串後面附加指定的字串
     * 
     * @param str
     *            原始字串
     * @param len
     *            指定長度
     * @param addstr
     *            欲附加的字串
     * @return 組合後字串
     */
    public static String addStrByFixedLength(String str, int len, String addstr) {
        String[] tempStr = splitFixedLength(str, len);
        StringBuilder strgrp = new StringBuilder();
        if (tempStr.length == 1) {
            strgrp.append(tempStr[0]);
        } else {
            for (int i = 0; i < tempStr.length; i++) {
                strgrp.append(tempStr[i]).append(addstr);
            }
        }
        return strgrp.toString();
    }

    @SuppressWarnings("rawtypes")
    public static int getEntityFileldLegth(Class clazz, String filedName, int defValue) {
        try {
            return clazz.getDeclaredField(filedName).getAnnotation(Column.class).length();
        } catch (Exception e) {
            e.printStackTrace();
            return defValue;
        }
    }
}
