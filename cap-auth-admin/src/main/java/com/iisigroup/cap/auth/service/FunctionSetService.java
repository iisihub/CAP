package com.iisigroup.cap.auth.service;

import java.util.List;
import java.util.Map;

import com.iisigroup.cap.auth.model.Function;
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
public interface FunctionSetService {

    Function findFunctionByCode(String code);

    List<Function> findFunctionBySysTypeAndLevel(String sysType, String level);

    int deleteRfList(String funcCode, List<String> delRole);

    Page<Map<String, Object>> findPage(ISearch search, String sysType,
            String funcCode);

    Page<Map<String, Object>> findEditPage(ISearch search, String sysType,
            String funcCode);

    void save(Function function, IRequest request);
}
