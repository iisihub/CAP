package com.iisigroup.cap.base.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.iisigroup.cap.base.dao.BranchDao;
import com.iisigroup.cap.base.dao.CodeItemDao;
import com.iisigroup.cap.base.dao.RoleDao;
import com.iisigroup.cap.base.dao.RoleSetDao;
import com.iisigroup.cap.base.dao.UserDao;
import com.iisigroup.cap.base.model.Branch;
import com.iisigroup.cap.base.model.CodeItem;
import com.iisigroup.cap.base.service.RoleSetService;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.service.AbstractService;

/**
 * <pre>
 * 角色權限維護
 * </pre>
 * 
 * @since 2014/1/16
 * @author tammy
 * @version <ul>
 *          <li>2014/1/16,tammy,new
 *          </ul>
 */
@Service("roleSetService")
public class RoleSetServiceImpl extends AbstractService implements
        RoleSetService {

    @Resource
    private BranchDao brnDao;

    @Resource
    private CodeItemDao codeItemDao;

    @Resource
    private RoleDao roleDao;

    @Resource
    private RoleSetDao roleSetDao;

    @Resource
    private UserDao userDao;

    @Override
    public Page<Map<String, Object>> findPageUsr(ISearch search, String rolCode) {
        return userDao.findPageByRoleCode(rolCode, search.getFirstResult(),
                search.getMaxResults());
    }

    @Override
    public Page<Map<String, Object>> findPageEditUsr(ISearch search,
            String rolCode, String unitNo) {
        return userDao.findPageUnselectedByRoleCodeAndUnitNo(rolCode, unitNo,
                search.getFirstResult(), search.getMaxResults());
    }

    @Override
    public Page<Map<String, Object>> findPageEditFunc(ISearch search,
            String rolCode, String systyp, String pgmTyp) {
        return codeItemDao.findPageUnselected(rolCode, systyp, pgmTyp,
                search.getFirstResult(), search.getMaxResults());
    }

    @Override
    public Page<Map<String, Object>> findPageFunc(ISearch search, String rolCode) {
        return codeItemDao.findPageByRoleCode(rolCode, search.getFirstResult(),
                search.getMaxResults());
    }

    @Override
    public Map<String, String> findAllBranch() {
        Map<String, String> map = new LinkedHashMap<String, String>();
        List<Branch> brns = brnDao.findByAllBranch();

        if (!CollectionUtils.isEmpty(brns)) {
            for (Branch brn : brns) {
                map.put(brn.getDepartno(), brn.getDepartnm());
            }
        }
        return map;
    }

    @Override
    public Map<String, String> findAllFunc(String systyp) {
        Map<String, String> map = new LinkedHashMap<String, String>();
        List<CodeItem> pgms = codeItemDao.findBySystypAndStep(systyp, "1");

        if (!CollectionUtils.isEmpty(pgms)) {
            for (CodeItem pgm : pgms) {
                map.put(Integer.toString(pgm.getCode()), pgm.getName());
            }
        }
        return map;
    }

    @Override
    public int deleteRlset(String rolCode, List<String> delUsr) {
        return roleSetDao.deleteByRoleCodeAndUserIds(rolCode, delUsr);
    }

    @Override
    public int deleteRlf(String rolCode, List<String> delFunc) {
        return codeItemDao.deleteByRoleCodeAndPgmCodes(rolCode, delFunc);
    }

    @Override
    public List<Map<String, Object>> findAllRoleWithSelectedByUserOid(
            String userOid) {
        return roleDao.findAllWithSelectedByUserOid(userOid);
    }

}
