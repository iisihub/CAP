package com.iisigroup.cap.base.dao;

import java.util.List;

import com.iisigroup.cap.base.model.Branch;
import com.iisigroup.cap.dao.IGenericDao;

/**
 * <pre>
 * 分行資訊DAO
 * </pre>
 * 
 * @since 2011/8/30
 * @author Fantasy
 * @version <ul>
 *          <li>2011/8/30,Fantasy,new
 *          </ul>
 */
public interface BranchDao extends IGenericDao<Branch> {

	/**
	 * 取得所有分行資訊(含已停業)
	 * 
	 * @return List<Branch>
	 */
	public List<Branch> findByAllBranch();

	/**
	 * 取得所有分行資訊(不含已停業)
	 * 
	 * @return List<Branch>
	 */
	public List<Branch> findByAllActBranch();

	/**
	 * 查詢分行
	 * 
	 * @param brNo
	 *            分行代碼
	 * @return {@link com.mega.eloan.common.model.Branch}
	 */
	public Branch findByBrno(String brNo);

}
