package com.iisigroup.cap.base.service;

import com.iisigroup.cap.base.model.AuditConfig;

/**
 * <pre>
 * 存取AuditLog
 * </pre>
 * 
 * @since Jun 1, 2011
 * @author Administrator
 * @version $Id$
 * @version <ul>
 *          <li>Jun 1, 2011,Administrator,new
 *          <li>2013/01/16,UFO,add reload()
 *          </ul>
 */
public interface AuditConfigService {

	/**
	 * 取得不記錄的類型
	 * 
	 * @param targetName
	 *            target name
	 * @return 不需要記錄的類型
	 */
	public String getDisableType(String targetName);

	/**
	 * 載入所有Audit Config
	 */
	public void reload();
	
	public void save(AuditConfig auditConfig);
	
	public void delete(AuditConfig auditConfig);
	
	/**
	 * 查詢記錄Audit Log的設定
	 * @param targetName 不需記錄的 Handler名稱
	 * @param disableType 不需記錄的類型
	 * @return {@link com.mega.eloan.common.model.AuditConfig}
	 */
	public AuditConfig find(String targetName, String disableType);
	
	/**
	 * 查詢記錄Audit Log的設定
	 * @param targetName 不需記錄的 Handler名稱
	 * @return {@link com.mega.eloan.common.model.AuditConfig}
	 */
	public AuditConfig find(String targetName);

}
