package com.iisigroup.cap.base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.base.dao.AuditLogConfigDao;
import com.iisigroup.cap.base.dao.BaseDao;
import com.iisigroup.cap.base.model.AuditConfig;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;

/**
 * <pre>
 *  Access Log Config DAO
 * </pre>
 * 
 * @since 2011/06/01
 * @author UFO
 * @version <ul>
 *          <li>2011/06/01,UFO,new
 *          <li>2013/01/16,UFO,add findAll()
 *          </ul>
 */
@Repository
public class AuditLogConfigDaoImpl extends BaseDao<AuditConfig> implements
		AuditLogConfigDao {

	@Override
	public AuditConfig find(String targetName, String disableType) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "targetName",
				targetName);
		search.addSearchModeParameters(SearchMode.EQUALS, "disableType",
				disableType);
		return findUniqueOrNone(search);
	}

	@Override
	public AuditConfig find(String oid) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "oid", oid);
		return findUniqueOrNone(search);
	}

	public List<AuditConfig> findByTargetName(String targetName) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "targetName",
				targetName);
		return find(search);
	}

	@Override
	public List<AuditConfig> findAll() {
		ISearch search = createSearchTemplete();
		search.setFirstResult(0).setMaxResults(Integer.MAX_VALUE);
		return find(search);
	}

}
