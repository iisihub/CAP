/*
 * GenericDao.java
 *
 * Copyright (c) 2009-2012 International Integrated System, Inc.
 * 11F, No.133, Sec.4, Minsheng E. Rd., Taipei, 10574, Taiwan, R.O.C.
 * All Rights Reserved.
 *
 * Licensed Materials - Property of International Integrated System,Inc.
 *
 * This software is confidential and proprietary information of
 * International Integrated System, Inc. ("Confidential Information").
 */
package com.iisigroup.cap.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.iisigroup.cap.dao.IGenericDao;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.dao.utils.SearchMode;
import com.iisigroup.cap.dao.utils.SearchModeParameter;
import com.iisigroup.cap.model.IDataObject;
import com.iisigroup.cap.model.Page;

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
 *          <li>2013/5/21,增加SearchMode or & and 的查詢設定
 *          </ul>
 * @param <T>
 */
public abstract class GenericDao<T> implements IGenericDao<T> {

	protected Class<T> type;
	protected Logger logger;

	public abstract EntityManager getEntityManager();

	@SuppressWarnings("unchecked")
	public GenericDao() {
		try {
			type = (Class<T>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
		} catch (ClassCastException e) {
			Class<T> clazz = (Class<T>) getClass().getGenericSuperclass();
			type = (Class<T>) ((ParameterizedType) clazz.getGenericSuperclass())
					.getActualTypeArguments()[0];
		}
		logger = LoggerFactory.getLogger(getClass());
	}// ;

	/**
	 * Insert.
	 * 
	 * @param entity
	 *            the entry
	 */
	public void save(Object entity) {
		Assert.notNull(entity, "The entity to save cannot be null element");
		if (!getEntityManager().contains(entity)) {
			getEntityManager().persist(entity);
		}
	}// ;

	public void save(List<?> entries) {
		for (Object entity : entries) {
			Assert.notNull(entity, "The List must not contain null element");
			save(entity);
		}
	}// ;

	public void merge(T entity) {
		Assert.notNull(entity, "The entity to save cannot be null element");
		getEntityManager().merge(entity);
	}// ;

	/**
	 * Delete.
	 * 
	 * @param entity
	 *            the entry
	 */
	public void delete(Object entity) {
		if (getEntityManager().contains(entity)) {
			getEntityManager().remove(entity);
		} else {
			// could be a delete on a transient instance
			T entityRef = getEntityManager().getReference(type,
					getPrimaryKey(entity));

			if (entityRef != null) {
				getEntityManager().remove(entityRef);
			}
		}
	}// ;

	public void delete(List<?> entries) {
		for (Object entity : entries) {
			delete(entity);
		}
	}// ;

	/**
	 * Find.
	 * 
	 * @param pk
	 *            the oid
	 * 
	 * @return the t
	 */
	public T find(Serializable pk) {
		return getEntityManager().find(type, pk);
	}// ;

	public Serializable getPrimaryKey(Object model) {
		if (model instanceof IDataObject) {
			return (Serializable) ((IDataObject) model).getOid();
		} else {
			return null;
		}
	}

	public T find(T entity) {
		Serializable pk = getPrimaryKey(entity);
		if (pk == null) {
			return null;
		}
		return (T) getEntityManager().find(type, pk);
	}// ;

	public T findUniqueOrNone(ISearch search) {
		search.setFirstResult(0).setMaxResults(1);
		List<T> models = find(getType(), search);
		if (models != null && !models.isEmpty()) {
			return models.iterator().next();
		}
		return null;
	}// ;

	public Iterator<T> list(int first, int count) {
		ISearch search = createSearchTemplete();
		search.setFirstResult(first).setMaxResults(count);
		return createQuery(getType(), search).getResultList().iterator();
	}// ;

	@Override
	public int count(ISearch search) {
		return count(getType(), search);
	}

	public List<T> find(final ISearch search) {
		return createQuery(getType(), search).getResultList();
	}// ;

	/**
	 * 查詢頁的資料
	 * 
	 * @param search
	 *            SearchSetting
	 * @return Page<S>
	 */
	public Page<T> findPage(ISearch search) {
		return findPage(getType(), search);
	}// ;

	/**
	 * find by SearchSetting
	 * 
	 * @param <S>
	 *            bean
	 * @param search
	 *            SearchSetting
	 * @param clazz
	 *            Class<S>
	 * @return List<S>
	 */
	public <S> List<S> find(Class<S> clazz, final ISearch search) {
		return createQuery(clazz, search).getResultList();
	}// ;

	/**
	 * 取得筆數
	 * 
	 * @param <S>
	 *            bean
	 * @param clazz
	 *            Class<S>
	 * @param search
	 *            SearchSetting
	 * @return int
	 */
	public <S> int count(Class<S> clazz, ISearch search) {
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Long> query = builder.createQuery(Long.class);
		Root<S> root = query.from(clazz);
		query = applySpecificationToCriteria(root, query, builder, search);
		query.select(builder.count(root));
		Long count = getEntityManager().createQuery(query).getSingleResult();
		return count.intValue();
	}// ;

	/**
	 * 查詢頁的資料
	 * 
	 * @param <S>
	 *            bean
	 * @param clazz
	 *            Class<S>
	 * @param search
	 *            SearchSetting
	 * @return Page<S>
	 */
	public <S> Page<S> findPage(Class<S> clazz, ISearch search) {
		return new Page<S>(find(clazz, search), count(clazz, search),
				search.getMaxResults(), search.getFirstResult());
	}// ;

	protected <S> TypedQuery<S> createQuery(Class<S> clazz, ISearch search) {
		ISearch thisSearch = (search != null) ? search : createSearchTemplete();
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<S> query = builder.createQuery(clazz);
		Root<S> root = query.from(clazz);

		query = applySpecificationToCriteria(root, query, builder, thisSearch);
		TypedQuery<S> tquery = applyPaginationAndOrderToCriteria(root, query,
				builder, thisSearch);
		return tquery;
	}// ;

	protected TypedQuery<T> createQuery(ISearch search) {
		ISearch thisSearch = (search != null) ? search : createSearchTemplete();
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(getType());
		Root<T> root = query.from(getType());

		query = applySpecificationToCriteria(root, query, builder, thisSearch);
		TypedQuery<T> tquery = applyPaginationAndOrderToCriteria(root, query,
				builder, thisSearch);
		return tquery;
	}// ;

	/**
	 * 設定查詢條件
	 * 
	 * @param <S>
	 * @param root
	 *            Root
	 * @param query
	 *            CriteriaQuery
	 * @param builder
	 *            CriteriaBuilder
	 * @param search
	 *            SearchSetting
	 * @return CriteriaQuery
	 */
	@SuppressWarnings({ "rawtypes" })
	protected <S> CriteriaQuery<S> applySpecificationToCriteria(Root root,
			CriteriaQuery<S> query, CriteriaBuilder builder, ISearch search) {
		if (search.getSearchModeParameters() != null) {
			Predicate[] aryWhere = new Predicate[search
					.getSearchModeParameters().size()];
			int i = 0;
			for (SearchModeParameter param : search.getSearchModeParameters()) {
				CapSpecifications spec = new CapSpecifications(param);
				aryWhere[i++] = spec.toPredicate(root, query, builder);
			}
			query.where(builder.and(aryWhere));
		}

		return query;
	}// ;

	/**
	 * 設定查詢筆數及欄位排列順序
	 * 
	 * @param root
	 *            Root
	 * @param query
	 *            CriteriaQuery
	 * @param builder
	 *            CriteriaBuilder
	 * @param search
	 *            SearchSetting
	 * @return TypedQuery
	 */
	protected <S> TypedQuery<S> applyPaginationAndOrderToCriteria(Root<S> root,
			CriteriaQuery<S> query, CriteriaBuilder builder, ISearch search) {
		// set order criteria if available
		if (search.hasOrderBy()) {

			Map<String, Boolean> orderMap = search.getOrderBy();
			List<Order> orders = new ArrayList<Order>();
			// int i = 0;
			for (Entry<String, Boolean> entry : orderMap.entrySet()) {
				Expression<?> expression = null;
				String[] pathElements = entry.getKey().split("\\.");
				int pathSize = pathElements.length;
				if (pathSize > 1) {
					Path<?> path = root.get(pathElements[0]);
					for (int i = 1; i <= pathElements.length - 1; i++) {
						path = path.get(pathElements[i]);
					}
					expression = path;
				} else {
					expression = root.get(entry.getKey());
				}
				orders.add((entry.getValue()) ? builder.desc(expression)
						: builder.asc(expression));

			}
			query.orderBy(orders);
		}
		TypedQuery<S> tQuery = getEntityManager().createQuery(query);
		if (search != null) {
			// set pagination if needed
			tQuery.setFirstResult(search.getFirstResult());
			tQuery.setMaxResults(search.getMaxResults());
		}
		return tQuery;
	}// ;

	// -------------------------------------------------------
	/**
	 * <pre>
	 * CapSpecifications
	 * </pre>
	 */
	@SuppressWarnings("rawtypes")
	class CapSpecifications {

		private SearchMode _searchMode;
		private Object _key;
		private Object _value;

		SearchModeParameter param;

		CapSpecifications(SearchModeParameter param) {
			this._searchMode = param.getMode();
			this._key = param.getKey();
			this._value = param.getValue();
		}

		@SuppressWarnings({ "unchecked", "incomplete-switch" })
		public Predicate toPredicate(Root root, CriteriaQuery query,
				CriteriaBuilder builder) {
			try {
				if (_key instanceof SearchModeParameter
						&& _value instanceof SearchModeParameter) {
					CapSpecifications spec_key = new CapSpecifications(
							(SearchModeParameter) _key);
					CapSpecifications spec_value = new CapSpecifications(
							(SearchModeParameter) _value);
					if (SearchMode.OR == _searchMode) {
						return builder.or(
								spec_key.toPredicate(root, query, builder),
								spec_value.toPredicate(root, query, builder));
					} else if (SearchMode.AND == _searchMode) {
						return builder.and(
								spec_key.toPredicate(root, query, builder),
								spec_value.toPredicate(root, query, builder));
					} else {
						return null;
					}
				} else if (SearchMode.OR == _key || SearchMode.AND == _key) {
					List<SearchModeParameter> list = (List<SearchModeParameter>) _value;
					List<Predicate> predicates = new ArrayList<Predicate>(
							list.size());
					for (SearchModeParameter param : list) {
						predicates.add(new CapSpecifications(param)
								.toPredicate(root, query, builder));
					}
					if (SearchMode.OR == _key) {
						return builder.or(predicates
								.toArray(new Predicate[predicates.size()]));
					} else {
						return builder.and(predicates
								.toArray(new Predicate[predicates.size()]));
					}
				}
				String key = (String) _key;

				String[] pathElements = key.split("\\.");

				Path<?> path = root.get(pathElements[0]);
				for (int i = 1; i <= pathElements.length - 1; i++) {
					path = path.get(pathElements[i]);
				}

				switch (_searchMode) {

				case BETWEEN:
					Object[] values = asArray(_value);
					if (values != null) {
						return builder.between((Path<Comparable>) path,
								asComparable(values[0]),
								asComparable(values[1]));
					} else {
						return null;
					}
				case GREATER_THAN:
					return builder.greaterThan((Path<Comparable>) path,
							asComparable(_value));
				case GREATER_EQUALS:
					return builder.greaterThanOrEqualTo(
							(Path<Comparable>) path, asComparable(_value));
				case LESS_THAN:
					return builder.lessThan((Path<Comparable>) path,
							asComparable(_value));
				case LESS_EQUALS:
					return builder.lessThanOrEqualTo((Path<Comparable>) path,
							asComparable(_value));
				case IS_NULL:
					return builder.isNull(path);
				case IS_NOT_NULL:
					return builder.isNotNull(path);
				case IN:
					return path.in(asArray(_value));
				case NOT_IN:
					return builder.not(path.in(asArray(_value)));
				case LIKE:
					return builder.like((Path<String>) path,
							String.valueOf(_value));
				case NOT_LIKE:
					return builder.notLike((Path<String>) path,
							String.valueOf(_value));
				case EQUALS:
					return builder.equal(path, _value);
				case NOT_EQUALS:
					return builder.notEqual(path, _value);
				}
			} catch (Exception e) {
				logger.error(e.getLocalizedMessage(), e);
			}
			return null;
		}

		private Comparable asComparable(Object value) {
			if (value instanceof Comparable) {
				return (Comparable<?>) value;
			} else {
				return null;
			}
		}

		@SuppressWarnings("unused")
		private Collection<?> asCollection(Object value) {
			if (value instanceof Collection) {
				return (Collection<?>) value;
			} else if (value.getClass().isArray()) {
				return Arrays.asList(value);
			}
			return Arrays.asList(value);
		}

		private Object[] asArray(Object value) {
			if (value.getClass().isArray()) {
				Object[] result = new Object[Array.getLength(value)];
				for (int i = 0; i < result.length; ++i) {
					result[i] = Array.get(value, i);
				}
				return result;
			} else if (value instanceof Collection) {
				return ((Collection) value).toArray();
			}
			return null;
		}
	}

	public Class<T> getType() {
		return type;
	}

	@SuppressWarnings("rawtypes")
	public GenericDao setType(Class<T> type) {
		this.type = type;
		return this;
	}

	public ISearch createSearchTemplete() {
		return new SearchSetting();
	}

	public void flush() {
		getEntityManager().flush();
		getEntityManager().clear();
	}

}
