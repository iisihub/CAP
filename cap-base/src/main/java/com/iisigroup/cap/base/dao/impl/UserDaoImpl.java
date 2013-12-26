/* 
 * ElsUserDaoImpl.java
 *
 * IBM Confidential
 * GBS Source Materials
 * 
 * Copyright (c) 2011 IBM Corp. 
 * All Rights Reserved.
 */
package com.iisigroup.cap.base.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.iisigroup.cap.base.dao.BaseDao;
import com.iisigroup.cap.base.model.Role;
import com.iisigroup.cap.base.model.User;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;
import com.iisigroup.cap.security.dao.IUserDao;

//import tw.com.iisi.cap.dao.utils.ISearch;
//import tw.com.iisi.cap.dao.utils.SearchMode;
//import tw.com.iisi.cap.dao.utils.SearchModeParameter;
//import tw.com.iisi.cap.util.CapString;
//
//import com.mega.eloan.common.dao.AbstractAPJpaDao;
//import com.mega.eloan.common.dao.ElsUserDao;
//import com.mega.eloan.common.model.ElsUser;
//import com.mega.eloan.common.model.ElsUser_;

/**
 * <pre>
 * 使用者資訊Dao
 * </pre>
 * 
 * @since 2013/12/20
 * @author tammy
 * @version <ul>
 *          <li>2013/12/20,tammy,new
 *          </ul>
 */
@Repository
public class UserDaoImpl extends BaseDao<User> implements IUserDao<User> {

	@Override
	public User getUserByLoginId(String loginId, String unitNo) {
		ISearch search = createSearchTemplete();
		search.addSearchModeParameters(SearchMode.EQUALS, "userId", loginId);
		return findUniqueOrNone(search);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getRoleByUser(User user) {
		//select rle.* from DEF_RLE rle inner join DEF_RLSET rls inner join DEF_USR usr on usr.STAFFPID=rls.STAFFPID on rle.ROLCODE=rls.ROLCODE where rle.STU='0' and usr.STAFFPID=:userId
		Query query = getEntityManager().createNativeQuery("select rle.* from DEF_RLE rle inner join DEF_RLSET rls inner join DEF_USR usr on usr.STAFFPID=rls.STAFFPID on rle.ROLCODE=rls.ROLCODE where rle.STU='0' and usr.STAFFPID=?1", Role.class);
		//TODO: systemtype
		query.setParameter(1, user.getUserId());
		return query.getResultList();
	}

}
