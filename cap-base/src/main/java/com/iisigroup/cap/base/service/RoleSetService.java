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

	public Page<Map<String, Object>> findPageUsr(ISearch search, String rolCode);

	public Page<Map<String, Object>> findPageEditUsr(ISearch search,
			String rolCode, String unitNo);

	public Page<Map<String, Object>> findPageFunc(ISearch search, String rolCode);

	public Page<Map<String, Object>> findPageEditFunc(ISearch search,
			String rolCode, String systyp, String pgmTyp);

	public Map<String, String> findAllBranch();

	public Map<String, String> findAllFunc(String systyp);

	public int deleteRlset(String rolCode, List<String> delUsr);
	
	public int deleteRlf(String rolCode, List<String> delFunc);
}
