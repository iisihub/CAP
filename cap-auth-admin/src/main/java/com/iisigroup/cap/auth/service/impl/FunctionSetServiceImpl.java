package com.iisigroup.cap.auth.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iisigroup.cap.auth.dao.FunctionDao;
import com.iisigroup.cap.auth.dao.RoleDao;
import com.iisigroup.cap.auth.dao.RoleFunctionDao;
import com.iisigroup.cap.auth.model.Function;
import com.iisigroup.cap.auth.service.FunctionSetService;
import com.iisigroup.cap.base.dao.I18nDao;
import com.iisigroup.cap.base.model.I18n;
import com.iisigroup.cap.component.IRequest;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.operation.simple.SimpleContextHolder;
import com.iisigroup.cap.security.CapSecurityContext;
import com.iisigroup.cap.service.AbstractService;
import com.iisigroup.cap.utils.CapBeanUtil;
import com.iisigroup.cap.utils.CapDate;
import com.iisigroup.cap.utils.CapString;
import com.iisigroup.cap.utils.CapWebUtil;

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
@Service
public class FunctionSetServiceImpl extends AbstractService implements
        FunctionSetService {

    @Resource
    private FunctionDao functionDao;
    @Resource
    private RoleDao roleDao;
    @Resource
    private RoleFunctionDao roleFunctionDao;
    @Resource
    private I18nDao i18nDao;

    @Override
    public Function findFunctionByCode(String code) {
        if (!CapString.isEmpty(code)) {
            return functionDao.findByCode(Integer.parseInt(code));
        }
        return null;
    }// ;

    @Override
    public List<Function> findFunctionBySysTypeAndLevel(String sysType, String level) {
        return functionDao.findBySysTypeAndLevel(sysType, level);
    }// ;

    @Override
    public Page<Map<String, Object>> findPage(ISearch search, String sysType,
            String funcCode) {
        return roleDao.findPageBySysTypeAndFuncCode(sysType, funcCode,
                search.getFirstResult(), search.getMaxResults());
    }// ;

    @Override
    public Page<Map<String, Object>> findEditPage(ISearch search,
            String sysType, String funcCode) {
        return roleDao.findPageUnselectedBySysTypeAndFuncCode(sysType, funcCode,
                search.getFirstResult(), search.getMaxResults());
    }// ;

    @Override
    public int deleteRfList(String funcCode, List<String> delRole) {
        return roleFunctionDao.deleteByFuncCodeAndRoleCodes(funcCode, delRole);
    }// ;

    @Override
    public void save(Function function, IRequest request) {
        if (function == null) {
            function = new Function();
        }
        CapBeanUtil.map2Bean(request, function, Function.class);
        function.setUpdater(CapSecurityContext.getUserId());
        function.setUpdateTime(CapDate.getCurrentTimestamp());
        functionDao.save(function);
        // insert menu i18n
        String i18nKey = "menu." + function.getCode();
        I18n i18n = i18nDao.findByCodeTypeAndCodeValue("menu", i18nKey,
                SimpleContextHolder.get(CapWebUtil.localeKey).toString());
        if (i18n == null) {
            i18n = new I18n();
        }
        i18n.setCodeDesc(function.getName());
        i18n.setCodeOrder(function.getSequence());
        i18n.setCodeType("menu");
        i18n.setCodeValue(i18nKey);
        i18n.setLocale(SimpleContextHolder.get(CapWebUtil.localeKey).toString());
        i18n.setUpdater(CapSecurityContext.getUserId());
        i18n.setUpdateTime(CapDate.getCurrentTimestamp());
        i18nDao.save(i18n);
    }// ;
}
