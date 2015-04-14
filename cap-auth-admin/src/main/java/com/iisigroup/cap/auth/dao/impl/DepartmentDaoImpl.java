package com.iisigroup.cap.auth.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.auth.dao.DepartmentDao;
import com.iisigroup.cap.auth.model.Department;
import com.iisigroup.cap.dao.impl.GenericDao;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;

/**
 * <pre>
 * 分行資訊DAOImpl
 * </pre>
 * 
 * @since 2011/8/30
 * @author Fantasy
 * @version <ul>
 *          <li>2011/8/30,Fantasy,new
 *          </ul>
 */
@Repository
public class DepartmentDaoImpl extends GenericDao<Department> implements DepartmentDao {

    @Override
    public List<Department> findByAllDepartment() {
        ISearch search = createSearchTemplete();
        search.setFirstResult(0).setMaxResults(Integer.MAX_VALUE);
        search.addOrderBy("code");
        return find(search);
    }

    @Override
    public List<Department> findByAllActDepartment() {
        ISearch search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.NOT_EQUALS, "status", "Y");
        search.setFirstResult(0).setMaxResults(Integer.MAX_VALUE);
        search.addOrderBy("code");
        return find(search);
    }

    @Override
    public Department findByCode(String code) {
        ISearch search = createSearchTemplete();
        search.addSearchModeParameters(SearchMode.EQUALS, "code", code);
        return findUniqueOrNone(search);
    }

}
