package com.iisigroup.cap.report.enums;

/**
 * <pre>
 * font type enum
 * </pre>
 * 
 * @since 2014/4/1
 * @author tammy
 * @version <ul>
 *          <li>2014/4/1,tammy,new
 *          </ul>
 */
public enum FontTypeEnum {
	微軟正黑體("MSJH.TTF");

	private String fontName;

	FontTypeEnum(String fontName) {
		this.fontName = fontName;
	}

	@Override
	public String toString() {
		return fontName;
	}
}
