package com.iisigroup.cap.base.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.iisigroup.cap.base.dao.AuditDataDao;
import com.iisigroup.cap.base.model.AuditData;
import com.iisigroup.cap.base.service.AuditDataService;
import com.iisigroup.cap.service.AbstractService;

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
@Service
public class AuditDataServiceImpl extends AbstractService implements
		AuditDataService {
	private final Logger logger = LoggerFactory
			.getLogger(AuditDataServiceImpl.class);
	
	@Resource
	AuditDataDao auditDataDao;

	@Override
	public List<AuditData> findAuditData(String sysId, String logSno) {
		List<AuditData> list = auditDataDao.find(sysId, logSno);
		if(CollectionUtils.isEmpty(list)){
			return new ArrayList<AuditData>();
		}
		return list;
	}

}
