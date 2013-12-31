package com.iisigroup.cap.base.dao;

import java.util.List;

import com.iisigroup.cap.base.model.AuditConfig;
import com.iisigroup.cap.dao.IGenericDao;

/**
 * <pre>
 * Access Log Config DAO
 * </pre>
 * 
 * @since 2011/06/01
 * @author UFO * @version
 *         <ul>
 *         <li>2011/06/01,UFO,new
 *         <li>2013/01/16,UFO,add findAll()
 *         </ul>
 */
public interface AuditLogConfigDao extends IGenericDao<AuditConfig> {

	/**
	 * 查詢記錄Audit Log的設定
	 * 
	 * @param targetName
	 *            不需記錄的 Handler名稱
	 * @param disableType
	 *            不需記錄的類型
	 * @return {@link com.mega.eloan.common.model.AuditConfig}
	 */
	public AuditConfig find(String targetName, String disableType);

	/**
	 * 查詢記錄Audit Log的設定
	 * 
	 * @param targetName
	 *            不需記錄的 Handler名稱
	 * @return {@link com.mega.eloan.common.model.AuditConfig}
	 */
	public AuditConfig find(String targetName);

	/**
	 * 依targetName搜尋是否有定義不需要記錄
	 * 
	 * @param targetName
	 *            package+classname
	 * @return AuditLogConfig List
	 */
	public List<AuditConfig> findByTargetName(String targetName);

	/**
	 * 取得所有的Audit Log設定
	 * 
	 * @return 所有的Audit Log設定
	 */
	public List<AuditConfig> findAll();
}
