/* 
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.rule.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iisigroup.cap.component.impl.AjaxFormResult;
import com.iisigroup.cap.rule.dao.DivCtDtlDao;
import com.iisigroup.cap.rule.dao.DivCtItmDao;
import com.iisigroup.cap.rule.model.DivCtDtl;
import com.iisigroup.cap.rule.model.DivCtItm;
import com.iisigroup.cap.rule.service.ConditionMntService;
import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * Condition Maintain Service
 * </pre>
 * 
 * @since 2013/12/16
 * @author TimChiang
 * @version
 *          <ul>
 *          <li>2013/12/16,TimChiang,new
 *          </ul>
 */
@Service
public class ConditionMntServiceImpl implements ConditionMntService {

    @Resource
    private DivCtItmDao ctItmDao;

    @Resource
    private DivCtDtlDao ctDtlDao;

    @Override
    public void saveDivCtItm(DivCtItm ctItm) {
        ctItmDao.save(ctItm);
        if (ctItm.getDivCtDtls() != null) {
            ctDtlDao.save(ctItm.getDivCtDtls());
        }
    }

    @Override
    public Map<String, String> findByDivCtItmNos(String[] DivCtItmNos) {
        List<DivCtItm> ftList = ctItmDao.findByDivCtItmNo(DivCtItmNos);
        Map<String, String> m = new LinkedHashMap<String, String>();
        if (!ftList.isEmpty()) {
            for (DivCtItm c : ftList) {
                m.put(c.getDivCtNo(), c.getDivCtNm());
            }
        }
        return m;
    }

    @Override
    public DivCtItm findByDivCtItmNo(String divCtNo) {
        return ctItmDao.findByDivCtItmNo(divCtNo);
    }

    @Override
    public Map<String, Map<String, String>> findMapByCtItmNos(String[] nos) {
        List<DivCtItm> ftList = ctItmDao.findByDivCtItmNoAndInputFlg(nos, "1");
        Map<String, Map<String, String>> m = new LinkedHashMap<String, Map<String, String>>();
        if (!ftList.isEmpty()) {
            for (int i = 0; i < nos.length; i++) {
                Map<String, String> map = new LinkedHashMap<String, String>();
                for (DivCtItm c : ftList) {
                    if (nos[i].equals(c.getDivCtNo())) {
                        map.put(c.getDivCtNo(), c.getDivCtNm());
                        m.put(nos[i], map);
                    }
                }
            }
        }
        return m;
    }

    @Override
    public Map<String, AjaxFormResult> getDivCtItmsByNos(String[] nos) {
        List<DivCtItm> ftList = ctItmDao.findByDivCtItmNoAndInputFlg(nos, "1");
        Map<String, AjaxFormResult> m = new LinkedHashMap<String, AjaxFormResult>();
        if (!ftList.isEmpty()) {
            for (DivCtItm c : ftList) {
                String ctItmNo = c.getDivCtNo();
                AjaxFormResult sm = m.get(ctItmNo);
                if (sm == null) {
                    sm = new AjaxFormResult();
                }
                sm.set(c.getDivCtNo(), c.getDivCtNm());
                m.put(ctItmNo, sm);
            }
        }
        return m;
    }

    @Override
    public DivCtItm getByCtItmNo(String ctItmNo) {
        return ctItmDao.findByDivCtItmNo(ctItmNo);
    }

    @Override
    public DivCtItm getById(String oid) {
        return ctItmDao.find(oid);
    }

    @Override
    public void deleteById(String oid) {
        DivCtItm ctItm = ctItmDao.find(oid);
        if (ctItm != null) {
            if (ctItm.getDivCtDtls() != null) {
                ctDtlDao.delete(ctItm.getDivCtDtls());
            }
            ctItmDao.delete(ctItm);
        }
    }

    @Override
    public void deleteCtDtlByList(List<DivCtDtl> ctDtls) {
        ctDtlDao.delete(ctDtls);
    }

    @Override
    public List<DivCtDtl> findCtDtlsByCtNoAndSort(String conditionNo) {
        if (!CapString.isEmpty(conditionNo)) {
            return ctDtlDao.findCtDtlsByCtNoAndSort(conditionNo);
        }
        return null;
    }
}
