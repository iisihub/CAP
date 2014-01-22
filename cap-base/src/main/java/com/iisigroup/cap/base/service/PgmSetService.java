package com.iisigroup.cap.base.service;

import java.util.List;
import java.util.Map;

import com.iisigroup.cap.base.model.CodeItem;
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
public interface PgmSetService {

	/**
	 * CodeItem
	 * 
	 * @param code
	 *            pk
	 * @return {@link com.iisigroup.cap.base.model.CodeItem}
	 */
	public CodeItem find(String code);
	
	public List<CodeItem> findBySystypAndStep(String systyp, String step);

	public void savePgm(CodeItem model, List<String> setRole);
	
	public Page<Map<String, Object>> findPage(ISearch search, String systyp, String pgmCode);

}
