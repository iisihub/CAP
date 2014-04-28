package com.iisigroup.cap.auth.service;

import java.util.List;
import java.util.Map;

import com.iisigroup.cap.auth.model.CodeItem;
import com.iisigroup.cap.component.IRequest;
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
     * @return {@link com.iisigroup.cap.auth.model.CodeItem}
     */
    CodeItem find(String code);

    List<CodeItem> findBySystypAndStep(String systyp, String step);

    int deleteRlf(String pgmCode, List<String> delRole);

    Page<Map<String, Object>> findPage(ISearch search, String systyp,
            String pgmCode);

    Page<Map<String, Object>> findEditPage(ISearch search, String systyp,
            String pgmCode);

    void save(CodeItem codeItem, IRequest request);
}
