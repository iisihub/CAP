package com.iisigroup.cap.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iisigroup.cap.auth.dao.BranchDao;
import com.iisigroup.cap.auth.model.Branch;
import com.iisigroup.cap.auth.service.BranchService;
import com.iisigroup.cap.service.AbstractService;

/**
 * <pre>
 * 分行代碼維護
 * </pre>
 * 
 * @since 2012/2/17
 * @author UFOJ
 * @version <ul>
 *          <li>2012/2/17,UFOJ,new
 *          </ul>
 */
@Service
public class BranchServiceImpl extends AbstractService implements BranchService {

	@Autowired
	private BranchDao branchDao;

	@Override
	public void save(Branch model) {
		branchDao.save(model);
	}

	@Override
	public Branch findByBrno(String brNo) {
		return branchDao.findByBrno(brNo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mega.eloan.adm.service.ADM2050Service#findByAllBranch()
	 */
	@Override
	public List<Branch> findByAllBranch() {
		return branchDao.findByAllActBranch();
	}
}
