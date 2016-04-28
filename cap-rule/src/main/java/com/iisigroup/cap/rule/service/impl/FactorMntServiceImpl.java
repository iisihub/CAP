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

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.ibm.icu.util.Calendar;
import com.iisigroup.cap.response.AjaxFormResult;
import com.iisigroup.cap.rule.dao.CaseInfoDao;
import com.iisigroup.cap.rule.dao.DivFtDtlDao;
import com.iisigroup.cap.rule.dao.DivFtItmDao;
import com.iisigroup.cap.rule.model.CaseInfo;
import com.iisigroup.cap.rule.model.DivFtDtl;
import com.iisigroup.cap.rule.model.DivFtItm;
import com.iisigroup.cap.rule.service.FactorMntService;
import com.iisigroup.cap.service.AbstractService;

/**
 * <pre>
 * Factor Maintain Service
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
public class FactorMntServiceImpl extends AbstractService implements FactorMntService {

    @Resource
    private DivFtItmDao ftItmDao;

    @Resource
    private DivFtDtlDao ftDtlDao;

    @Resource
    private CaseInfoDao caseInfoDao;

    @Override
    public void insertTestCaseInfoData() {
        BigDecimal[] amount = new BigDecimal[] { new BigDecimal(100000), new BigDecimal(150000), new BigDecimal(900000), new BigDecimal(999999), new BigDecimal(50000), new BigDecimal(330000),
                new BigDecimal(550000), new BigDecimal(330000), new BigDecimal(150000), new BigDecimal(260000), new BigDecimal(440000), new BigDecimal(100000), new BigDecimal(880000),
                new BigDecimal(330000), new BigDecimal(150000), new BigDecimal(150000), new BigDecimal(250000), new BigDecimal(440000), new BigDecimal(130000), new BigDecimal(300000) };

        Integer[] overDueDay = new Integer[] { 20, 90, 20, 31, 20, 20, 44, 29, 20, 77, 30, 66, 88, 20, 66, 90, 11, 30, 20, 15 };
        List<CaseInfo> caseList = new ArrayList<CaseInfo>();
        Calendar cal = Calendar.getInstance();
        int count = 1;
        for (int j = 1; j <= 20; j++) {
            for (int i = count; i <= (5000 * j); i++) {
                CaseInfo cas = new CaseInfo();
                cas.setCasNo(StringUtils.leftPad(String.valueOf(i), 20, '0'));
                int result = (int) (Math.random() * (20 - 1) + 1);
                cas.setAmount(amount[result]);
                result = (int) (Math.random() * (20 - 1) + 1);
                cas.setOverDueDay(overDueDay[result]);
                cas.setCreator("System");
                cas.setCreateTime(new Timestamp(cal.getTimeInMillis()));
                caseList.add(cas);
                count++;
            }
            caseInfoDao.save(caseList);
            System.out.println(" case info records :: " + caseList.size());
        }
    }

    @Override
    public void saveDivFtItm(DivFtItm ftItm) {
        ftItmDao.save(ftItm);
        if (ftItm.getDivFtDtls() != null) {
            ftDtlDao.merge(ftItm.getDivFtDtls());
        }
    }

    @Override
    public Map<String, String> findByDivFtItmNos(String[] divFtItmNos) {
        List<DivFtItm> ftList = ftItmDao.findByDivFtItmNo(divFtItmNos);
        Map<String, String> m = new LinkedHashMap<String, String>();
        if (!ftList.isEmpty()) {
            for (DivFtItm c : ftList) {
                m.put(c.getFactorNo(), c.getFactorNm());
            }
        }
        return m;
    }

    @Override
    public DivFtItm findByDivFtItmNo(String divFtItmNo) {
        return ftItmDao.findByDivFtItmNo(divFtItmNo);
    }

    @Override
    public List<DivFtItm> findAllDivFtItm() {
        return ftItmDao.findAllFtItm();
    }

    @Override
    public Map<String, Map<String, String>> findMapByFtItmNos(String[] nos) {
        List<DivFtItm> ftList = ftItmDao.findByDivFtItmNo(nos);
        Map<String, Map<String, String>> m = new LinkedHashMap<String, Map<String, String>>();
        if (!ftList.isEmpty()) {
            for (int i = 0; i < nos.length; i++) {
                Map<String, String> map = new LinkedHashMap<String, String>();
                for (DivFtItm c : ftList) {
                    if (nos[i].equals(c.getFactorNo())) {
                        map.put(c.getFactorNo(), c.getFactorNm());
                        m.put(nos[i], map);
                    }
                }
            }
        }
        return m;
    }

    @Override
    public Map<String, AjaxFormResult> getDivFtItmByNos(String[] nos) {
        List<DivFtItm> ftList = ftItmDao.findByDivFtItmNo(nos);
        Map<String, AjaxFormResult> m = new LinkedHashMap<String, AjaxFormResult>();
        if (!ftList.isEmpty()) {
            for (DivFtItm c : ftList) {
                String ftItmNo = c.getFactorNo();
                AjaxFormResult sm = m.get(ftItmNo);
                if (sm == null) {
                    sm = new AjaxFormResult();
                }
                sm.set(c.getFactorNo(), c.getFactorNm());
                m.put(ftItmNo, sm);
            }
        }
        return m;
    }

    @Override
    public DivFtItm getByFtItmNo(String ftItmNo) {
        return ftItmDao.findByDivFtItmNo(ftItmNo);
    }

    @Override
    public DivFtItm getById(String oid) {
        return ftItmDao.find(oid);
    }

    @Override
    public void deleteById(String oid) {
        DivFtItm ftItm = ftItmDao.find(oid);
        if (ftItm != null) {
            if (ftItm.getDivFtDtls() != null) {
                ftDtlDao.delete(ftItm.getDivFtDtls());
            }
            ftItmDao.delete(ftItm);
        }
    }

    @Override
    public DivFtDtl findByFactorNoAndRangeNo(String factorNo, String rangeNo) {
        return ftDtlDao.findByFactorNoAndRangeNo(factorNo, rangeNo);
    }

    @Override
    public List<DivFtDtl> findByFactorNoAndRangeNos(String factorNo, String[] rangeNos) {
        return ftDtlDao.findByFactorNoAndRangeNos(factorNo, rangeNos);
    }

    @Override
    public void deleteFtDtlByList(List<DivFtDtl> list) {
        ftDtlDao.delete(list);
    }
}
