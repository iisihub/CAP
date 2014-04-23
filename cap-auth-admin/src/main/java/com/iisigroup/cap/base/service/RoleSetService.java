package com.iisigroup.cap.base.service;

import java.util.List;
import java.util.Map;

import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.model.Page;

/**
 * <pre>
 * 系統功能維護
 * </pre>
 * 
 * @since 2014/1/16
 * @author tammy
 * @version <ul>
 *          <li>2014/1/16,tammy,new
 *          </ul>
 */
public interface RoleSetService {

	Page<Map<String, Object>> findPageUsr(ISearch search, String rolCode);

	Page<Map<String, Object>> findPageEditUsr(ISearch search,
			String rolCode, String unitNo);

	Page<Map<String, Object>> findPageFunc(ISearch search, String rolCode);

	Page<Map<String, Object>> findPageEditFunc(ISearch search,
			String rolCode, String systyp, String pgmTyp);

	Map<String, String> findAllBranch();

	Map<String, String> findAllFunc(String systyp);

	int deleteRlset(String rolCode, List<String> delUsr);
	
	int deleteRlf(String rolCode, List<String> delFunc);

    List<Map<String, Object>> findAllRoleWithSelectedByUserOid(String userOid);
}
