package com.iisigroup.cap.auth.dao;

import java.util.List;

import com.iisigroup.cap.auth.model.Branch;
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
    List<Branch> findByAllBranch();

    /**
     * 取得所有分行資訊(不含已停業)
     * 
     * @return List<Branch>
     */
    List<Branch> findByAllActBranch();

    /**
     * 查詢分行
     * 
     * @param brNo
     *            分行代碼
     * @return {@link com.mega.eloan.common.model.Branch}
     */
    Branch findByBrno(String brNo);

}
