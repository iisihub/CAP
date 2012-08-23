/*
 * Copyright (c) 2009-2012 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System, Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
 */
package com.iisigroup.cap.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.iisigroup.cap.Constants;

/**
 * 
 * <p>
 * 字串處理.
 * </p>
 * 
 * 
 * @author malo
 * @version <ul>
 *          <li>2010/6/1,iristu,新增trimLineSeparator(),處理字串中斷行符號.
 *          <li>2011/9/7,SunkistWang,update checkRegularMatch(), 避開NPE.
 *          <li>2011/11/1,rodeschen,from cap
 *          </ul>
 */
public class StringUtil {

	public final static char[] hexChar = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	/**
	 * 將byte陣列轉為十六進位字串 如{0x01, 0x02} => 0102 (Move from
	 * tw.com.iisi.ettk.api.API.java)
	 * 
	 * @param ba
	 *            傳入byte陣列
	 * @return 轉換後的字串陣列
	 */
	public static String byteArrayToHexString(byte[] ba) {
		if (ba == null) {
			return "";
		}
		char[] ca = new char[2 * ba.length];
		for (int i = 0; i < ca.length; i += 2) {
			byte b = ba[i / 2];
			ca[i] = hexChar[(b >> 4) & 0xf];
			ca[i + 1] = hexChar[b & 0xf];
		}
		return new String(ca);
	}

	/**
	 * hex string to byte array ex. 6364 -> [c][d]
	 * 
	 * @param s
	 *            input string
	 * @return output byte array
	 */
	public static byte[] hexStrToByteArray(String s) {
		byte[] ba = new byte[s.length() / 2];
		for (int i = 0; i < s.length(); i += 2) {
			String ch = s.substring(i, i + 2);
			ba[i / 2] = (byte) Integer.parseInt(ch, 16);
		}
		return ba;
	}

	/**
	 * 在字串前面補空白.
	 * 
	 * @param in
	 *            the input string
	 * @param length
	 *            the output string length
	 * @return the output string
	 */
	public static String fillBlankHead(String in, int length) {
		return fillString(in, length, true, ' ');
	}

	/**
	 * 在字串前面補0.
	 * 
	 * @param in
	 *            the input
	 * @param length
	 *            補滿的字串長度
	 * @return String
	 */
	public static String fillZeroHead(String in, int length) {
		return fillString(in, length, true, '0');
	}

	/**
	 * fill space character to tail of string to length.
	 * 
	 * @param in
	 *            the input string
	 * @param length
	 *            the output string length
	 * @return the output string
	 */
	public static String fillBlankTail(String in, int length) {
		return fillString(in, length, false, ' ');
	}

	/**
	 * 在字串後面補0
	 * 
	 * @param in
	 *            the input
	 * @param length
	 *            補滿的字串長度
	 * @return String
	 */
	public static String fillZeroTail(String in, int length) {
		return fillString(in, length, false, '0');
	}

	/**
	 * fill specify character to string. 對字串補特殊字元.
	 * 
	 * @param in
	 *            the input string. 輸入字串.
	 * @param length
	 *            the output string length. 長度.
	 * @param rightAlign
	 *            true, the source string is right alignment, otherwise the
	 *            output string is left alignment. 是否右靠.
	 * @param ch
	 *            the append character. 填滿的字元.
	 * @return the output string. 輸出加長後字串.
	 */
	public static String fillString(String in, int length, boolean rightAlign, char ch) {

		StringBuffer sb = new StringBuffer();
		if (in == null) {
			in = ""; //$NON-NLS-1$
		}
		int inLength = in.getBytes().length;
		if (inLength >= length) {
			return in;
		} else {
			int loopLength = ch < 256 ? length - inLength : (length - inLength) / 2;
			for (int i = 0; i < loopLength; i++) {
				sb.append(ch);
			}
			if (rightAlign) {
				sb.append(in);
			} else {
				sb.insert(0, in);
			}
		}
		return sb.toString();
	}// ;

	/**
	 * fill specify character to string. 對字串補特殊字元.
	 * 
	 * @param rStr
	 *            the input string. 輸入字串.
	 * @param length
	 *            the output string length. 長度.
	 * @param rightAlign
	 *            true, the source string is right alignment, otherwise the
	 *            output string is left alignment. 是否右靠.
	 * @param ch
	 *            the append character. 填滿的字元.
	 * @param charset
	 *            the input string charset.
	 * @return the output string. 輸出加長後字串.
	 */
	public static String fillString(String rStr, int length, boolean rightAlign, String ch, String charset) {
		if (rStr == null) {
			rStr = Constants.EMPTY_STRING;
		}
		try {
			StringBuffer st = new StringBuffer(rStr);
			while (st.toString().getBytes(charset).length < length) {
				if (rightAlign) {
					st.insert(0, ch);
				} else {
					st.append(ch);
				}
			}
			rStr = st.toString();
			if (rStr.getBytes(charset).length > length) {
				if (rightAlign) {
					int index = rStr.getBytes(charset).length - length;
					rStr = new String(rStr.getBytes(charset), index, length, charset);
				} else {
					rStr = new String(rStr.getBytes(charset), 0, length, charset);
				}

			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return rStr;
	}

	/**
	 * trimNull 當傳入值為Null時，則回傳空字串。不為Null時，則回傳trim過的String
	 * 
	 * @param o
	 *            the input
	 * @return string
	 */
	public static String trimNull(Object o) {
		if (o != null && !"".equals(o)) {
			return (o.toString()).trim();
		} else {
			return Constants.EMPTY_STRING;
		}
	}// ;

	static final char[] fullSpace = "　".toCharArray();

	static char[] space = " ".toCharArray();

	/**
	 * <pre>
	 * trim全形空白
	 * </pre>
	 * 
	 * @param in
	 *            the input
	 * @return String
	 */
	public static String trimFullSpace(String in) {
		if (isEmpty(in)) {
			return "";
		}
		char[] tempValue = in.trim().toCharArray();
		StringBuffer sb = new StringBuffer(in.trim());
		for (int i = tempValue.length - 1; i >= 0; i--) {
			if (tempValue[i] == fullSpace[0] || tempValue[i] == space[0]) {
				sb.deleteCharAt(i);
			} else {
				break;
			}
		}
		return sb.toString();
	}// ;

	/**
	 * 判斷字串是否為空白.
	 * 
	 * @param s
	 *            字串
	 * @return boolean
	 */
	public static boolean isEmpty(String s) {
		return s == null || s.trim().length() == 0;
	}

	/**
	 * 
	 * 判斷字串是否與正規表示式相同
	 * 
	 * @param str
	 *            字串
	 * @param regEx
	 *            正規表示式
	 * @return boolean
	 */
	public static boolean checkRegularMatch(String str, String regEx) {
		if (StringUtil.isEmpty(str)) {
			return false;
		}
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.find();
	}

	/**
	 * <pre>
	 * 最得第一個符合條件之字串
	 * </pre>
	 * 
	 * @param str
	 *            the input
	 * @param regEx
	 *            正規式表示式
	 * @return String
	 * 
	 */
	public static String getRegularMatch(String str, String regEx) {
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return (m.find()) ? m.group() : Constants.EMPTY_STRING;
	}// ;

	/**
	 * 
	 * 判斷傳入之字串是否為數字
	 * 
	 * @param str
	 *            input string
	 * @return boolean
	 */
	public static boolean isNumeric(String str) {
		return str.matches("^[0-9]+$");
	}

	private static Map<Character, Character> helfConvertMap;
	static {
		helfConvertMap = new HashMap<Character, Character>();
		helfConvertMap.put(' ', '\u3000');
		helfConvertMap.put('"', '”');
		helfConvertMap.put('\'', '’');
		helfConvertMap.put('.', '。');
		helfConvertMap.put('[', '〔');
		helfConvertMap.put(']', '〕');
		helfConvertMap.put('^', '︿');
		helfConvertMap.put('_', '﹍');
		helfConvertMap.put('`', '‵');
	}

	/**
	 * 轉全型
	 * 
	 * @param str
	 *            the input string
	 * @return 全型String
	 */
	public static String halfWidthToFullWidth(String str) {
		char[] chs = str.toCharArray();
		char[] rtn = new char[chs.length];
		for (int i = 0; i < chs.length; i++) {
			char ch = chs[i];
			if (!(ch >= '\u2000') && (ch <= '\ufffd')) {
				if (helfConvertMap.containsKey(ch)) {
					rtn[i] = helfConvertMap.get(ch);
				}
				if ((ch > '\u0020') && (ch <= '\u007f')) {
					rtn[i] = (char) (ch - '\u0020' + 0xff00);
				}
			} else {
				rtn[i] = ch;
			}
		}
		return new String(rtn);
	}// ;

	/**
	 * trim Left
	 * 
	 * @param source
	 *            source
	 * @return String
	 */
	public static String trimLeft(String source) {
		if (isEmpty(source)) {
			return source;
		}
		if (source.trim().length() == 0)
			return "";
		int index = 0;
		for (int i = 0; i < source.length(); i++) {
			if (Character.isWhitespace(source.charAt(i))) {
				index = i + 1;
			} else {
				break;
			}
		}
		return index != 0 ? source.substring(index) : source;
	}// ;

	/**
	 * 將字串中有斷行的符號去除
	 * 
	 * @param source
	 *            String
	 * @return String
	 */
	public static String trimLineSeparator(String source) {
		if (isEmpty(source)) {
			return source;
		}
		source = source.replaceAll("\r\n", "");
		source = source.replaceAll("\n", "");
		return source;
	}

	public static String flattenArrayAsString(Object[] objects) {
		if (objects != null) {
			StringBuilder builder = new StringBuilder("");
			for (Object o : objects) {
				if (o != null) {
					builder.append(o.toString());
				} else {
					builder.append("null");
				}
				builder.append(",");
			}
			return builder.toString();
		}
		return "";
	}

	public static String getUUIDString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 截取所需長度字串
	 * 
	 * @param in
	 *            字串
	 * @param encoding
	 *            編碥
	 * @param len
	 *            所需長度
	 * @return String
	 */
	public static String cutString(String in, String encoding, int len) {
		if (in == null)
			return in;
		try {
			if (in.getBytes(encoding).length > len) {
				return new String(in.getBytes(encoding), 0, len, encoding);
			}
		} catch (UnsupportedEncodingException e) {
			if (in.getBytes().length > len) {
				return new String(in.getBytes(), 0, len);
			}
		}
		return in;
	}

	/**
	 * trimNull 當傳入值為Null時，則回傳為指定name字串。不為Null時，則回傳trim 過的String
	 * 
	 * @param o
	 *            the input
	 * @param name
	 *            the string
	 * @return string
	 */
	public static String trimNull(Object o, String name) {
		if (o != null && !"".equals(o)) {
			return (o.toString()).trim();
		} else {
			return name;
		}
	}// ;

	/**
	 * Array transform String
	 * 
	 * @param ary
	 *            String[]
	 * @return String
	 */
	public static String array2String(String[] ary) {
		StringBuffer sb = new StringBuffer();
		for (String s : ary) {
			sb.append(s).append(',');
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}// ;

	/**
	 * 解析每行數據獲取數據庫每個欄位對應的數據集合
	 * 
	 * @param dataString
	 *            一行數據
	 * @param delimit
	 *            分隔符號
	 * @return List<String> 數據集合
	 */
	public static List<String> split(String dataString, String delimit) {
		int delSize = delimit.trim().length();
		List<String> list = new ArrayList<String>();
		dataString = dataString + delimit;
		int j = 0;
		while ((j = dataString.indexOf(delimit)) != -1) {
			String str = dataString.substring(0, j);
			dataString = dataString.substring(j + delSize, dataString.length());
			list.add(str);
		}
		return list;
	}

}
