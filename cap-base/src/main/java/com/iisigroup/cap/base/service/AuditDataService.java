package com.iisigroup.cap.base.service;

import java.util.List;

import com.iisigroup.cap.base.model.AuditData;

/**
 * <pre>
 * 使用者操作歷史紀錄查詢
 * </pre>
 * 
 * @since 2012/2/17
 * @author UFOJ
 * @version <ul>
 *          <li>2012/2/17,UFOJ,new
 *          </ul>
 */
public interface AuditDataService {

	/**
	 * 查詢LOG
	 * 
	 * @param sysId
	 *            系統代碼
	 * @param logSno
	 *            SON
	 * @return List<AuditData>
	 */
	public List<AuditData> findAuditData(String sysId, String logSno);

}
