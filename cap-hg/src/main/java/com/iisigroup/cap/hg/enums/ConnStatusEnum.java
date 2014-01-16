package com.iisigroup.cap.hg.enums;

/**
 * <pre>
 * HG Connection status enum
 * </pre>
 * 
 * @since 2011/11/25
 * @author rodeschen
 * @version <ul>
 *          <li>2011/11/25,rodeschen,new
 *          </ul>
 */
public enum ConnStatusEnum {

	INIT("0"),
	RUNNING("1"),
	COMPLETE("2"),
	ERROR("3"),
	CONNECT_ERROR("4"),
	TIMEOUT(	"5");

	private String code;

	ConnStatusEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
