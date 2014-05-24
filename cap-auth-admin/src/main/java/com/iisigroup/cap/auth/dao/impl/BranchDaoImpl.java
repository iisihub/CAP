package com.iisigroup.cap.auth.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.auth.dao.BranchDao;
import com.iisigroup.cap.auth.model.Branch;
import com.iisigroup.cap.dao.impl.GenericDao;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;

/**
 * <pre>
 * 分行資訊DAOImpl
 * </pre>
 * 
 * @since 2011/8/30
 * @author Fantasy
 * @version <ul>
 *          <li>2011/8/30,Fantasy,new
 *          </ul>
 */
@Repository
public class BranchDaoImpl extends GenericDao<Branch> implements
		BranchDao {

	@Override
	public List<Branch> findByAllBranch() {
		ISearch search = createSearchTemplete();
		search.setFirstResult(0).setMaxResults(Integer.MAX_VALUE);
		search.addOrderBy("departno");
		return find(search);
	}
	
	@Override
	public List<Branch> findByAllActBranch() {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.NOT_EQUALS, "abrekflg", "Y");
		search.setFirstResult(0).setMaxResults(Integer.MAX_VALUE);
		search.addOrderBy("departno");
		return find(search);
	}

	@Override
	public Branch findByBrno(String brNo) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "departno", brNo);
		return findUniqueOrNone(search);
	}

}
