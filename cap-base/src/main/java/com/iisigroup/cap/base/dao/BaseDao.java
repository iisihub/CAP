package com.iisigroup.cap.base.dao;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

//@Repository
public class BaseDao<T> extends CapJpaDao<T> {

	@Override
	// 加入 EntityManager
	@Resource(name = "capEntityManager")
	public void setEntityManager(EntityManager entityManager) {
		super.setEntityManager(entityManager);
	}

}
