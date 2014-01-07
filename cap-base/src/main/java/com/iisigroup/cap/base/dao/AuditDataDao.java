package com.iisigroup.cap.base.dao;

import java.util.List;

import com.iisigroup.cap.base.model.AuditData;
import com.iisigroup.cap.dao.IGenericDao;

/**
 * <pre>
 * Access Audit Data DAO
 * </pre>
 * 
 * @since 2014/01/07
 * @author tammy * @version
 *         <ul>
 *         <li>2014/01/07,tammy,new
 *         </ul>
 */
public interface AuditDataDao extends IGenericDao<AuditData> {

	/**
	 * 查詢記錄Audit Data
	 * 
	 * @param sysId
	 *            
	 * @param logSno
	 *            
	 * @return {@link com.mega.eloan.common.model.AuditData}
	 */
	public List<AuditData> find(String sysId, String logSno);

}
