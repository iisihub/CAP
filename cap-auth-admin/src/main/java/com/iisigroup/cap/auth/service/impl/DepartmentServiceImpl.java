package com.iisigroup.cap.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iisigroup.cap.auth.dao.DepartmentDao;
import com.iisigroup.cap.auth.model.Department;
import com.iisigroup.cap.auth.service.DepartmentService;
import com.iisigroup.cap.service.AbstractService;

/**
 * <pre>
 * 分行代碼維護
 * </pre>
 * 
 * @since 2012/2/17
 * @author UFOJ
 * @version
 *          <ul>
 *          <li>2012/2/17,UFOJ,new
 *          </ul>
 */
@Service
public class DepartmentServiceImpl extends AbstractService implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public void save(Department model) {
        departmentDao.save(model);
    }

    @Override
    public Department findByBrno(String brNo) {
        return departmentDao.findByCode(brNo);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.mega.eloan.adm.service.ADM2050Service#findByAllBranch()
     */
    @Override
    public List<Department> findByAllBranch() {
        return departmentDao.findByAllActDepartment();
    }
}
