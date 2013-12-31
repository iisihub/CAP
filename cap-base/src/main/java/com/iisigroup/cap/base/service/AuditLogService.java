package com.iisigroup.cap.base.service;

import com.iisigroup.cap.base.model.AuditLog;

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
 *          </ul>
 */
public interface AuditLogService {

	/**
	 * 儲存Access Log
	 * 
	 * @param model
	 *            AuditLog Entity Object
	 */
	void log(AuditLog model);

}
