package com.iisigroup.cap.base.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iisigroup.cap.base.dao.AuditLogDao;
import com.iisigroup.cap.base.model.AuditLog;
import com.iisigroup.cap.base.service.AuditLogService;

/**
 * <pre>
 * 實作存取AuditLog的服務
 * </pre>
 * 
 * @since Jun 1, 2011
 * @author UFO
 * @version $Id$
 * @version <ul>
 *          <li>Jun 1, 2011,UFO,new
 *          </ul>
 */
@Service
public class AuditLogServiceImpl implements AuditLogService {

	@Resource
	AuditLogDao auditLogDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mega.eloan.common.service.AuditLogService#save(com.mega.eloan.common
	 * .model.AuditLog)
	 */
	@Override
	public void log(AuditLog model) {
		auditLogDao.save(model);
	}
}
