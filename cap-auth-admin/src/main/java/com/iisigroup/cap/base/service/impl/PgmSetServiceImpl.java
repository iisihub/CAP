package com.iisigroup.cap.base.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iisigroup.cap.base.dao.CodeItemDao;
import com.iisigroup.cap.base.dao.I18nDao;
import com.iisigroup.cap.base.dao.RoleDao;
import com.iisigroup.cap.base.model.CodeItem;
import com.iisigroup.cap.base.model.I18n;
import com.iisigroup.cap.base.service.PgmSetService;
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
@Service("pgmSetService")
public class PgmSetServiceImpl extends AbstractService implements PgmSetService {

    @Resource
    private CodeItemDao codeItemDao;
    @Resource
    private RoleDao roleDao;
    @Resource
    private I18nDao i18nDao;

    @Override
    public CodeItem find(String code) {
        if (!CapString.isEmpty(code)) {
            return codeItemDao.find(Integer.parseInt(code));
        }
        return null;
    }

    @Override
    public List<CodeItem> findBySystypAndStep(String systyp, String step) {
        return codeItemDao.findBySystypAndStep(systyp, step);
    }

    @Override
    public Page<Map<String, Object>> findPage(ISearch search, String systyp,
            String pgmCode) {
        return roleDao.findPageBySysTypeAndPgmCode(systyp, pgmCode,
                search.getFirstResult(), search.getMaxResults());
    }

    @Override
    public Page<Map<String, Object>> findEditPage(ISearch search,
            String systyp, String pgmCode) {
        return roleDao.findPageUnselectedBySysTypeAndPgmCode(systyp, pgmCode,
                search.getFirstResult(), search.getMaxResults());
    }

    @Override
    public int deleteRlf(String pgmCode, List<String> delRole) {
        return roleDao.deleteByPgmCodeAndRoleCodes(pgmCode, delRole);
    }

    @Override
    public void save(CodeItem codeItem, IRequest request) {
        if (codeItem == null) {
            codeItem = new CodeItem();
        }
        CapBeanUtil.map2Bean(request, codeItem, CodeItem.class);
        codeItem.setUpdater(CapSecurityContext.getUserId());
        codeItem.setUpdateTime(CapDate.getCurrentTimestamp());
        codeItemDao.save(codeItem);
        // insert menu i18n
        String i18nKey = "menu." + codeItem.getCode();
        I18n i18n = i18nDao.findByCodeTypeAndCodeValue("menu", i18nKey,
                SimpleContextHolder.get(CapWebUtil.localeKey).toString());
        if (i18n == null) {
            i18n = new I18n();
        }
        i18n.setCodeDesc(codeItem.getName());
        i18n.setCodeOrder(codeItem.getSeq());
        i18n.setCodeType("menu");
        i18n.setCodeValue(i18nKey);
        i18n.setLocale(SimpleContextHolder.get(CapWebUtil.localeKey).toString());
        i18n.setUpdater(CapSecurityContext.getUserId());
        i18n.setUpdateTime(CapDate.getCurrentTimestamp());
        i18nDao.save(i18n);
    }
}
