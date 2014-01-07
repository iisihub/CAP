package com.iisigroup.cap.base.service.impl;

import java.lang.management.MemoryUsage;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.iisigroup.cap.base.dao.AuditLogConfigDao;
import com.iisigroup.cap.base.model.AuditConfig;
import com.iisigroup.cap.base.service.AuditConfigService;
import com.iisigroup.cap.service.AbstractService;
import com.iisigroup.cap.utils.ManagementUtils;

/**
 * <pre>
 * AuditLog的設定服務(以負面表列列出不需寫AuditLog的Class Name)
 * </pre>
 * 
 * @since Jun 1, 2011
 * @author UFO
 * @version $Id$
 * @version <ul>
 *          <li>Jun 1, 2011,UFO,new
 *          <li>2013/01/16,UFO,add findAll()
 *          </ul>
 */
@Service
public class AuditConfigServiceImpl extends AbstractService implements AuditConfigService {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AuditConfigServiceImpl.class);

	@Resource
	AuditLogConfigDao auditLogConfigDao;

	/**
	 * cache map
	 */
	private Map<String, String> configCache = new ConcurrentHashMap<String, String>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mega.eloan.common.service.AuditLogService#isLogEnabled(java.lang.
	 * String)
	 */
	@Override
	public String getDisableType(String targetName) {

		// List<AuditConfig> result = auditLogConfigDao
		// .findByTargetName(StringUtils.trimToEmpty(targetName));
		// if (result != null && result.size() > 0) {
		// return result.get(0).getDisableType();
		// }
		// return null;
		try {
			String type = configCache.get(targetName);
			LOGGER.debug("#getDisableType():targetName={}, TYPE={}",
					targetName, type);
			return type;
		} catch (Exception ex) {
			LOGGER.error("#getDisableType() EXCEPTION!!! targetName="
					+ targetName, ex);
			return AuditConfig.DisableType.ALL.getCode();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.eloan.common.service.AuditConfigService#reload()
	 */
	@PostConstruct
	@Override
	public synchronized void reload() {
		long t1 = System.currentTimeMillis();

		MemoryUsage heap1 = ManagementUtils.getCurrentMemUsage();

		if (configCache != null) {
			configCache.clear();
		} else {
			configCache = new ConcurrentHashMap<String, String>();
		}

		try {
			List<AuditConfig> configList = auditLogConfigDao.findAll();

			LOGGER.info("[reload] DB(findAllUserName) COST= {} ms ",
					(System.currentTimeMillis() - t1));

			long t2 = System.currentTimeMillis();

			if (configList != null) {
				for (AuditConfig config : configList) {
					configCache.put(config.getTargetName(),
							config.getDisableType());
				}
			}
			LOGGER.info("[reload] configCache size={}", configCache.size());
			LOGGER.info("[reload] configCache COST= {} ms ",
					(System.currentTimeMillis() - t2));

		} catch (Exception ex) {
			LOGGER.error("[reload]EXCEPTION!!", ex);
		} finally {
			LOGGER.info("[reload] {}", ManagementUtils.formatHeapMemoryUsage(
					heap1, ManagementUtils.getCurrentMemUsage()));
			LOGGER.info("[reload] TOTAL COST= {} ms ",
					(System.currentTimeMillis() - t1));
		}
	}
	
	@Override
	public void save(AuditConfig auditConfig) {
		auditLogConfigDao.save(auditConfig);
	}

	@Override
	public void delete(AuditConfig auditConfig) {
		auditLogConfigDao.delete(auditConfig);
	}

	@Override
	public AuditConfig find(String targetName) {
		return this.auditLogConfigDao.find(targetName);
	}
	
	@Override
	public AuditConfig find(String targetName, String disableType) {
		return this.auditLogConfigDao.find(targetName, disableType);
	}

}
