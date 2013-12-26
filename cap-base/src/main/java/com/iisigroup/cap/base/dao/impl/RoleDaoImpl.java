/* 
 * RoleDaoImpl.java
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
import com.iisigroup.cap.security.dao.IRoleDao;

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
public class RoleDaoImpl extends BaseDao<Role> implements IRoleDao<Role> {

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findByUrl(String system, String url) {
		Query query = getEntityManager().createNativeQuery(
				"select rle.* from DEF_RLE rle inner join DEF_RLF rlf inner join DEF_PGM pgm on rlf.ROLCODE=rle.ROLCODE on rlf.PGMCODE=pgm.PGMCODE where rle.SYSTYP= ?1 and rle.STU='0' and pgm.PGMPATH= ?2", Role.class);
		query.setParameter(1, system);
		query.setParameter(2, url);
		return (List<Role>) query.getResultList();
	}
}
