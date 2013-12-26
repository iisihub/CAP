package com.iisigroup.cap.utils;

public class StringUtil {

	public static String trim(String str) {
		if (str == null)
			return "";
		return str.trim();
	}
	
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
		if (in==null || in.length()==0) {
			return "";
		}
		char[] tempValue = in.trim().toCharArray();
		StringBuffer sb = new StringBuffer(in);
		for (int i = tempValue.length - 1; i >= 0; i--) {
			if (tempValue[i] == fullSpace[0] || tempValue[i] == space[0]) {
				sb.deleteCharAt(i);
			} else {
				break;
			}
		}
		return sb.toString();
	}// ;

}
