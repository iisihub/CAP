package com.iisigroup.cap.auth.service;

import java.util.List;
import java.util.Map;

import com.iisigroup.cap.auth.model.DefaultFunction;
import com.iisigroup.cap.component.Request;
import com.iisigroup.cap.dao.SearchSetting;
import com.iisigroup.cap.model.Page;

/**
 * <pre>
 * 系統功能維護
 * </pre>
 * 
 * @since 2014/1/16
 * @author tammy
 * @version
 *          <ul>
 *          <li>2014/1/16,tammy,new
 *          </ul>
 */
public interface FunctionSetService {

    DefaultFunction findFunctionByCode(String code);

    List<DefaultFunction> findFunctionBySysTypeAndLevel(String sysType, String level);

    int deleteRfList(String funcCode, List<String> delRole);

    Page<Map<String, Object>> findPage(SearchSetting search, String sysType, String funcCode);

    Page<Map<String, Object>> findEditPage(SearchSetting search, String sysType, String funcCode);

    void save(DefaultFunction function, Request request);
}
