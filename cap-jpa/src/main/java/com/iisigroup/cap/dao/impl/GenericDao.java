package com.iisigroup.cap.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.iisigroup.cap.context.CapParameter;
import com.iisigroup.cap.dao.IGenericDao;
import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.model.IDataObject;
import com.iisigroup.cap.response.GridResult;

/**
 * <pre>
 * Dao
 * </pre>
 * 
 * @since 2011/11/1
 * @author rodeschen
 * @version <ul>
 *          <li>2011/11/1,rodeschen,new
 *          <li>2011/11/20,gabriella,modify
 *          <li>2012/2/14,RodesChen,add resource name
 *          <li>2012/6/29,RodesChen,add findUniqueOrNone setMaxResults 1
 *          </ul>
 * @param <T>
 */
public class GenericDao<T> implements IGenericDao<T> {

	protected Class<T> type;
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@PersistenceContext
	protected EntityManager entityManager;

	@Resource(name = "userSqlStatement")
	protected CapParameter sqlParameter;

	/**
	 * Instantiates a new abstract common dao.
	 */
	@SuppressWarnings("unchecked")
	public GenericDao() {
		try {
			this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		} catch (ClassCastException e) {
			Class<T> clazz = (Class<T>) getClass().getGenericSuperclass();
			this.type = (Class<T>) ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[0];
		}
	}

	public void save(List<T> entries) {
		for (T entry : entries) {
			Assert.notNull(entry, "The List must not contain null element");
			save(entry);
		}
	}

	public void save(T entry) {
		getSession().saveOrUpdate(entry);
	}

	public void delete(List<T> entries) {
		for (T entry : entries) {
			T modelRef = find(entry);

			if (modelRef != null) {
				delete(modelRef);
			} else if (logger.isWarnEnabled()) {
				logger.warn("It is not present in the database: " + entry.toString());
			}
		}
	}

	public void delete(T entry) {
		getSession().delete(entry);
	}

	@SuppressWarnings("unchecked")
	public T find(Serializable pk) {
		return (T) getSession().get(type, pk);
	}

	protected Serializable getId(T model) {
		Assert.isInstanceOf(GenericBean.class, model);
		return (Serializable) ((IDataObject) model).getOid();
	}

	@SuppressWarnings("unchecked")
	public T find(T entry) {
		Serializable id = getId(entry);
		if (id == null) {
			return null;
		}
		return (T) getSession().get(type, id);
	}

	public int count(Criteria criteria) {
		criteria.setProjection(Projections.rowCount());

		Number count = (Number) criteria.uniqueResult();

		if (count != null) {
			return count.intValue();
		} else {
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	public T findUniqueOrNone(Criteria criteria) {
		List<T> models = criteria.setMaxResults(1).list();
		if (models != null && !models.isEmpty()) {
			return models.iterator().next();
		}
		return null;
	}// ;

	protected Criteria getCriteria() {
		Criteria criteria = null;
		criteria = getSession().createCriteria(type);
		return criteria;
	}// ;

	/*
	 * (non-Javadoc)
	 * 
	 * @see IGeneticDao#list(int, int)
	 */
	@SuppressWarnings("unchecked")
	public Iterator<T> list(int first, int count) {
		Session session = getSession();
		Criteria criteria = session.createCriteria(type);
		criteria.setFirstResult(first);
		criteria.setMaxResults(count);
		return criteria.list().iterator();
	}

	@SuppressWarnings("unchecked")
	public Iterator<T> list(String entityName, int first, int count) {
		Assert.hasLength(entityName, "entityName is null!!");
		Session session = getSession();
		Criteria criteria = session.createCriteria(entityName);
		criteria.setFirstResult(first);
		criteria.setMaxResults(count);
		return criteria.list().iterator();
	}

	public Class<T> getType() {
		return type;
	}

	/**
	 * Grid 分頁查詢
	 * 
	 * @param gridResult
	 *            gridResult
	 * @return List
	 */
	public GridResult findPage(GridResult gridResult) {
		return findPage(null, gridResult);
	}

	@SuppressWarnings("unchecked")
	public GridResult findPage(Criteria criteria, GridResult gridResult) {
		if (criteria == null) {
			criteria = getCriteria();
		}
		// 設定總筆數
		gridResult.setRecords(count(criteria));
		criteria.setProjection(null);
		int nowpage = gridResult.getPage();
		if (gridResult.getPage() == 0) {
			nowpage = 1;
		}
		if (gridResult.hasOrderBy()) {
			Map<String, Boolean> order = gridResult.getOrderBy();
			for (Entry<String, Boolean> entry : order.entrySet()) {
				criteria.addOrder((entry.getValue()) ? Order.desc(entry.getKey()) : Order.asc(entry.getKey()));
			}
		}
		criteria.setFirstResult((nowpage - 1) * gridResult.getPageRows());
		criteria.setMaxResults(gridResult.getPageRows());
		gridResult.setRowData(criteria.list());
		return gridResult;
	}

	protected void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	public CapParameter getSqlParameter() {
		return sqlParameter;
	}

	// public void setSqlParameter(CapParameter sqlParameter) {
	// this.sqlParameter = sqlParameter;
	// }

	/**
	 * Gets the session.
	 * 
	 * @return the session
	 */
	public Session getSession() {
		return (Session) getEntityManager().getDelegate();
	}

	public String getSql(String sqlId) {
		return getSqlParameter().getValue(sqlId);
	}

}
