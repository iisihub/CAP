package com.iisigroup.cap.base.service;

import java.util.List;
import java.util.Set;

import com.iisigroup.cap.base.model.CodeItem;

/**
 * <pre>
 * 
 * </pre>
 * 
 * @since 2013/12/20
 * @author tammy
 * @version <ul>
 *          <li>2013/12/20,tammy,new
 *          </ul>
 */
public interface CodeItemService {

	/**
	 * 依交易代碼取得CodeItem
	 * 
	 * @since 2011/05/31
	 * @author Fantasy
	 */
	CodeItem getCodeItemByCode(int code);
	
	/**
	 * findByParentAndSteps
	 * 
	 * @since 2011/05/10
	 * @author Fantasy
	 */
	List<CodeItem> findByParentAndSteps(String pgmDept, Set<String> roles,
			int parent, int... steps);
	
	/**
	 * findByStep
	 * 
	 * @since 2011/05/10
	 * @author Fantasy
	 */
	List<CodeItem> findByStep(Set<String> roles, int... step);

	/**
	 * findByParent
	 * 
	 * @since 2011/05/10
	 * @author Fantasy
	 */
	List<CodeItem> findByParent(Set<String> roles, int parent);

	/**
	 * findByParentAndSteps
	 * 
	 * @since 2011/05/10
	 * @author Fantasy
	 */
	List<CodeItem> findByParentAndSteps(Set<String> roles,
			int parent, int... steps);

}
