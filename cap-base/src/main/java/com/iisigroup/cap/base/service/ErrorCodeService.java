package com.iisigroup.cap.base.service;

import java.util.List;

import com.iisigroup.cap.base.model.ErrorCode;


/**
 * <pre>
 * 訊息代碼表
 * </pre>
 * 
 * @since 2012/03/29
 * @author UFOJ
 * @version <ul>
 *          <li>2012/03/29,UFO,new
 *          </ul>
 */
public interface ErrorCodeService {


	/**
	 * 重新載入分行資訊
	 */
	void reload();
	
	/**
	 * <pre>
	 * 新增或修改
	 * </pre>
	 * 
	 * @param entry
	 *            CBCLCODE
	 */
	void save(ErrorCode entry);

	/**
	 * get the error code by code and locale
	 * 
	 * @param ErrorCode
	 *            代碼類型
	 * @param locale
	 *            語系
	 * @return error code
	 * 
	 */
	ErrorCode getErrorCode(String code, String locale);

	List<ErrorCode> getErrorCodeListBySysId(String sysId, String locale);

}
