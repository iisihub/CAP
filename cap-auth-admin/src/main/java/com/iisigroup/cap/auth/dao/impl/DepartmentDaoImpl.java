package com.iisigroup.cap.auth.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.auth.dao.DepartmentDao;
import com.iisigroup.cap.auth.model.Department;
import com.iisigroup.cap.contants.SearchMode;
import com.iisigroup.cap.dao.SearchSetting;
import com.iisigroup.cap.dao.impl.GenericDaoImpl;

/**
 * <pre>
 * 分行資訊DAOImpl
 * </pre>
 * 
 * @since 2011/8/30
 * @author Fantasy
 * @version
 *          <ul>
 *          <li>2011/8/30,Fantasy,new
 *          </ul>
 */
@Repository
public class DepartmentDaoImpl extends GenericDaoImpl<Department> implements DepartmentDao {

    @Override
    public List<Department> findByAllDepartment() {
        SearchSetting search = createSearchTemplete();
        search.setFirstResult(0).setMaxResults(Integer.MAX_VALUE);
        search.addOrderBy("code");
        return find(search);
    }

    @Override
    public List<Department> findByAllActDepartment() {
        SearchSetting search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.NOT_EQUALS, "status", "Y");
        search.setFirstResult(0).setMaxResults(Integer.MAX_VALUE);
        search.addOrderBy("code");
        return find(search);
    }

    @Override
    public Department findByCode(String code) {
        SearchSetting search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "code", code);
        return findUniqueOrNone(search);
    }

}
