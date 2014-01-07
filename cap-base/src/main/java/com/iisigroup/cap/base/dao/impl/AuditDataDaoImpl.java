package com.iisigroup.cap.base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.base.dao.AuditDataDao;
import com.iisigroup.cap.base.dao.BaseDao;
import com.iisigroup.cap.base.model.AuditData;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;

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
@Repository
public class AuditDataDaoImpl extends BaseDao<AuditData> implements
		AuditDataDao {

	@Override
	public List<AuditData> find(String sysId, String logSno) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "logSno", logSno);
		search.addOrderBy("sno");

		return find(search);
	}
}
