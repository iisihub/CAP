/* 
 * CapNamedJdbcTemplate.java
 * 
 * Copyright (c) 2009-2012 International Integrated System, Inc. 
 * All Rights Reserved.
 * 
 * Licensed Materials - Property of International Integrated System, Inc.
 * 
 * This software is confidential and proprietary information of 
 * International Integrated System, Inc. (&quot;Confidential Information&quot;).
 */
package com.iisigroup.cap.jdbc;

import java.sql.BatchUpdateException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterBatchUpdateUtils;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterUtils;
import org.springframework.jdbc.core.namedparam.ParsedSql;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.iisigroup.cap.contants.CapJdbcContants;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.exception.CapDBException;
import com.iisigroup.cap.jdbc.support.CapColumnMapRowMapper;
import com.iisigroup.cap.jdbc.support.CapRowMapperResultSetExtractor;
import com.iisigroup.cap.jdbc.support.CapSqlSearchQueryProvider;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.utils.CapDbUtil;
import com.iisigroup.cap.utils.CapSqlStatement;

/**
 * <pre>
 * CapNamedJdbcTemplate
 * </pre>
 * 
 * @since 2012/8/17
 * @author iristu
 * @version <ul>
 *          <li>2012/8/17,iristu,new
 *          </ul>
 */
public class CapNamedJdbcTemplate {

	// default
	private Logger logger = LoggerFactory.getLogger(CapNamedJdbcTemplate.class);

	private NamedParameterJdbcTemplate namedjdbc;

	private CapSqlStatement sqlp;
	private CapSqlStatement sqltemp;

	private Class<?> causeClass;

	DataSource dataSource;

	public CapNamedJdbcTemplate() {
	}

	public void setSqltemp(CapSqlStatement sqltemp) {
		this.sqltemp = sqltemp;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.namedjdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public void setSqlProvider(CapSqlStatement privider) {
		this.sqlp = privider;
	}

	public void setCauseClass(Class<?> clazz) {
		this.causeClass = clazz;
		// this.logger = LoggerFactory.getLogger(clazz);
	}

	public void query(String sqlId, Map<String, Object> args,
			RowCallbackHandler rch) {
		StringBuffer sql = new StringBuffer(
				(String) sqlp.getValue(sqlId, sqlId));
		if (!sql.toString().trim().toUpperCase().startsWith("CALL")) {
			sql.append(' ').append(
					sqltemp.getValue(CapJdbcContants.SQLQuery_Suffix, ""));
		}
		if (logger.isTraceEnabled()) {
			logger.trace(new StringBuffer("SqlId=")
					.append(sqlp.containsKey(sqlId) ? sqlId : "")
					.append("\n\t")
					.append(CapDbUtil.convertToSQLCommand(sql.toString(), args))
					.toString());
		}
		long cur = System.currentTimeMillis();
		try {
			namedjdbc.query(sql.toString(), args, rch);
		} catch (Exception e) {
			throw new CapDBException(e, causeClass);
		} finally {
			logger.info("CapNamedJdbcTemplate spend {} ms",
					(System.currentTimeMillis() - cur));
		}
	}// ;

	/**
	 * 查詢
	 * 
	 * @param <T>
	 *            T
	 * @param sqlId
	 *            sql id
	 * @param appendDynamicSql
	 *            append dynamic sql
	 * @param args
	 *            參數
	 * @param startRow
	 *            開始筆數
	 * @param fetchSize
	 *            截取筆數
	 * @param rm
	 *            RowMapper
	 * @return List<T>
	 */
	public <T> List<T> query(String sqlId, String appendDynamicSql,
			Map<String, Object> args, int startRow, int fetchSize,
			RowMapper<T> rm) {
		StringBuffer sql = new StringBuffer(
				(String) sqlp.getValue(sqlId, sqlId));
		if (appendDynamicSql != null) {
			sql.append(' ').append(appendDynamicSql);
		}
		if (!sql.toString().trim().toUpperCase().startsWith("CALL")) {
			sql.append(' ').append(
					sqltemp.getValue(CapJdbcContants.SQLQuery_Suffix, ""));
		}
		if (logger.isTraceEnabled()) {
			logger.trace(new StringBuffer("SqlId=")
					.append(sqlp.containsKey(sqlId) ? sqlId : "")
					.append("\n\t")
					.append(CapDbUtil.convertToSQLCommand(sql.toString(), args))
					.toString());
		}
		long cur = System.currentTimeMillis();
		try {
			return namedjdbc.query(sql.toString(), (Map<String, Object>) args,
					new CapRowMapperResultSetExtractor<T>(rm, startRow,
							fetchSize));
		} catch (Exception e) {
			throw new CapDBException(e, causeClass);
		} finally {
			logger.info("CapNamedJdbcTemplate spend {} ms",
					(System.currentTimeMillis() - cur));
		}
	}// ;

	/**
	 * 查詢，查詢結果為List<Map<key, value>>
	 * 
	 * @param <T>
	 *            bean
	 * @param sqlId
	 *            sqlId
	 * @param appendDynamicSql
	 *            append sql
	 * @param args
	 *            傳入參數
	 * @param rm
	 *            RowMapper
	 * 
	 * @return List<T>
	 */
	public <T> List<T> query(String sqlId, String appendDynamicSql,
			Map<String, Object> args, RowMapper<T> rm) {
		StringBuffer sql = new StringBuffer(
				(String) sqlp.getValue(sqlId, sqlId));
		if (appendDynamicSql != null) {
			sql.append(' ').append(appendDynamicSql);
		}
		if (!sql.toString().trim().toUpperCase().startsWith("CALL")) {
			sql.append(' ').append(
					sqltemp.getValue(CapJdbcContants.SQLQuery_Suffix, ""));
		}
		if (logger.isTraceEnabled()) {
			logger.trace(new StringBuffer("SqlId=")
					.append(sqlp.containsKey(sqlId) ? sqlId : "")
					.append("\n\t")
					.append(CapDbUtil.convertToSQLCommand(sql.toString(), args))
					.toString());
		}
		long cur = System.currentTimeMillis();
		try {
			return namedjdbc.query(sql.toString(), (Map<String, Object>) args,
					new RowMapperResultSetExtractor<T>(rm));
		} catch (Exception e) {
			throw new CapDBException(e, causeClass);
		} finally {
			logger.info("CapNamedJdbcTemplate spend {} ms",
					(System.currentTimeMillis() - cur));
		}
	}// ;

	public List<Map<String, Object>> query(String sqlId,
			Map<String, Object> args) {
		return this.query(sqlId, null, args, new CapColumnMapRowMapper());
	}// ;

	/**
	 * 查詢，查詢結果為JavaBean
	 * 
	 * @param <T>
	 *            JavaBean
	 * @param sqlId
	 *            sqlId
	 * @param appendDynamicSql
	 *            append sql
	 * @param rm
	 *            RowMapper
	 * @param args
	 *            傳入參數
	 * @return T
	 * @throws GWException
	 */
	public <T> T queryForObject(String sqlId, String appendDynamicSql,
			Map<String, Object> args, RowMapper<T> rm) {
		List<T> list = this.query(sqlId, appendDynamicSql, args, rm);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}// ;

	/**
	 * 查詢，查詢結果為JavaBean
	 * 
	 * @param <T>
	 *            JavaBean
	 * @param sqlId
	 *            sqlId
	 * @param rm
	 *            RowMapper
	 * @param args
	 *            傳入參數
	 * @return T
	 * @throws GWException
	 */
	public <T> T queryForObject(String sqlId, Map<String, Object> args,
			RowMapper<T> rm) {
		return this.queryForObject(sqlId, null, args, rm);
	}// ;

	/**
	 * 查詢，查詢結果為Map<key,value>
	 * 
	 * @param sqlId
	 *            sqlId
	 * @param appendDynamicSql
	 *            append sql
	 * @param args
	 *            傳入參數
	 * @return Map<String, Object>
	 * @throws GWException
	 */
	public Map<String, Object> queryForMap(String sqlId,
			String appendDynamicSql, Map<String, Object> args) {
		return queryForObject(sqlId, appendDynamicSql, args,
				new CapColumnMapRowMapper());
	}// ;

	/**
	 * 查詢筆數專用
	 * 
	 * @param sqlId
	 *            sqlId
	 * @param args
	 *            args
	 * @return int
	 * @throws GWException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int queryForInt(String sqlId, Map<String, Object> args) {
		StringBuffer sql = new StringBuffer(
				(String) sqlp.getValue(sqlId, sqlId));
		sql.append(' ').append(
				sqltemp.getValue(CapJdbcContants.SQLQuery_Suffix, ""));
		if (logger.isTraceEnabled()) {
			logger.trace(new StringBuffer("SqlId=")
					.append(sqlp.containsKey(sqlId) ? sqlId : "")
					.append("\n\t")
					.append(CapDbUtil.convertToSQLCommand(sql.toString(), args))
					.toString());
		}
		long cur = System.currentTimeMillis();
		try {
			return namedjdbc.queryForInt(sql.toString(), (Map) args);
		} catch (Exception e) {
			throw new CapDBException(e, causeClass);
		} finally {
			logger.info("CapNamedJdbcTemplate spend {} ms",
					(System.currentTimeMillis() - cur));
		}
	}// ;

	/**
	 * 查詢，查詢結果為Map<key,value>
	 * 
	 * @param sqlId
	 *            sqlId
	 * @param args
	 *            傳入參數
	 * @return Map<String, Object>
	 * @throws GWException
	 */
	public Map<String, Object> queryForMap(String sqlId,
			Map<String, Object> args) {
		return this.queryForMap(sqlId, null, args);
	}// ;

	/**
	 * 新增、修改、刪除
	 * 
	 * @param sqlId
	 *            sqlId
	 * @param args
	 *            Map<String, ?>
	 * @return int
	 * @throws GWException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int update(String sqlId, Map<String, Object> args) {
		String sql = sqlp.getValue(sqlId, sqlId);
		if (logger.isTraceEnabled()) {
			logger.trace(new StringBuffer("SqlId=")
					.append(sqlp.containsKey(sqlId) ? sqlId : "")
					.append("\n\t")
					.append(CapDbUtil.convertToSQLCommand(sql, args))
					.toString());
		}
		long cur = System.currentTimeMillis();
		try {
			return namedjdbc.update(sql, (Map) args);
		} catch (Exception e) {
			throw new CapDBException(e, causeClass);
		} finally {
			logger.info("CapNamedJdbcTemplate spend {} ms",
					(System.currentTimeMillis() - cur));
		}
	}// ;

	public int batchUpdate(String sqlId, Map<String, Integer> sqlTypes,
			final List<Map<String, Object>> batchValues) {
		long cur = System.currentTimeMillis();
		try {
			int[] batchCount = null;
			String sql = sqlp.getValue(sqlId, sqlId);
			ParsedSql parsedSql = NamedParameterUtils.parseSqlStatement(sql);
			if (sqlTypes != null && !sqlTypes.isEmpty()) {
				MapSqlParameterSource[] batch = new MapSqlParameterSource[batchValues
						.size()];
				for (int i = 0; i < batchValues.size(); i++) {
					Map<String, Object> valueMap = batchValues.get(i);
					batch[i] = new MapSqlParameterSource();
					for (Entry<String, Integer> entry : sqlTypes.entrySet()) {
						if (!valueMap.containsKey(entry.getKey())) {
							valueMap.put(entry.getKey(), null);
						}
						batch[i].addValue(entry.getKey(),
								valueMap.get(entry.getKey()), entry.getValue());
					}
					if (logger.isTraceEnabled()) {
						logger.trace(new StringBuffer("SqlId=")
								.append(sqlp.containsKey(sqlId) ? sqlId : "")
								.append("\n#")
								.append((i + 1))
								.append("\t")
								.append(CapDbUtil.convertToSQLCommand(sql,
										valueMap)).toString());
					}
				}
				cur = System.currentTimeMillis();
				batchCount = NamedParameterBatchUpdateUtils
						.executeBatchUpdateWithNamedParameters(parsedSql,
								batch, namedjdbc.getJdbcOperations());

			} else {
				SqlParameterSource[] batch = SqlParameterSourceUtils
						.createBatch(batchValues
								.toArray(new HashMap[batchValues.size()]));
				cur = System.currentTimeMillis();
				batchCount = NamedParameterBatchUpdateUtils
						.executeBatchUpdateWithNamedParameters(parsedSql,
								batch, namedjdbc.getJdbcOperations());
			}
			int rows = 0;
			for (int i : batchCount) {
				rows += i;
			}
			return rows;
		} catch (Exception e) {
			Throwable cause = (Throwable) e;
			String msg = cause.getMessage();
			while ((cause = cause.getCause()) != null) {
				if (cause instanceof BatchUpdateException) {
					cause = ((BatchUpdateException) cause).getNextException();
				}
				msg = cause.getMessage();
			}
			throw new CapDBException(msg, e, causeClass);
		} finally {
			logger.info("CapNamedJdbcTemplate spend {} ms",
					(System.currentTimeMillis() - cur));
		}
	}// ;

	/**
	 * call SP
	 * 
	 * @param spName
	 *            SP Name
	 * @param params
	 *            SqlParameter/SqlOutParameter/SqlInOutParameter obj array
	 * @param inParams
	 *            SqlParameter values
	 * @return result map
	 */
	public Map<String, Object> callSPForMap(String spName,
			SqlParameter[] params, Map<String, ?> inParams) {

		int idx = spName.indexOf(".");
		String schemaName = null;
		if (idx != -1) {
			schemaName = spName.substring(0, idx);
			spName = spName.substring(idx + 1);
		}

		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource)
				.withProcedureName(spName).declareParameters(params);

		if (schemaName != null) {
			jdbcCall.setSchemaName(schemaName);
		}

		jdbcCall.setAccessCallParameterMetaData(false);

		Map<String, Object> out = jdbcCall.execute(inParams);
		return out;
	}// ;

	/**
	 * wrapper SqlRowSet queryForRowSet(String sql, Object[] args) from
	 * org.springframework.jdbc.core.JdbcTemplate
	 * 
	 * @param sqlId
	 *            sqlId
	 * @param args
	 *            參數
	 * @return SqlRowSet
	 */
	public SqlRowSet queryForRowSet(String sqlId, Map<String, Object> args) {
		StringBuffer sql = new StringBuffer(
				(String) sqlp.getValue(sqlId, sqlId));
		sql.append(' ').append(
				sqltemp.getValue(CapJdbcContants.SQLQuery_Suffix, ""));
		if (logger.isTraceEnabled()) {
			logger.trace(new StringBuffer("SqlId=")
					.append(sqlp.containsKey(sqlId) ? sqlId : "")
					.append("\n\t")
					.append(CapDbUtil.convertToSQLCommand(sql.toString(), args))
					.toString());
		}
		long cur = System.currentTimeMillis();
		try {
			return namedjdbc.queryForRowSet(sql.toString(), args);
		} catch (Exception e) {
			throw new CapDBException(e, causeClass);
		} finally {
			logger.info("CapNamedJdbcTemplate spend {} ms",
					(System.currentTimeMillis() - cur));
		}
	}// ;

	public List<Map<String, Object>> queryPaging(String sqlId,
			Map<String, Object> args, int startRow, int fetchSize) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(CapJdbcContants.SQLPaging_SourceSQL,
				sqlp.getValue(sqlId, sqlId));
		StringBuffer sql = new StringBuffer().append(CapDbUtil.spelParser(
				(String) sqltemp.getValue(CapJdbcContants.SQLPaging_Query),
				params, sqltemp.getParserContext()));
		sql.append(' ').append(
				sqltemp.getValue(CapJdbcContants.SQLQuery_Suffix, ""));
		if (args == null) {
			args = new HashMap<String, Object>();
		}
		args.put("startRow", startRow);
		args.put("endRow", startRow + fetchSize);
		if (logger.isTraceEnabled()) {
			logger.trace(new StringBuffer("\n\t").append(
					CapDbUtil.convertToSQLCommand(sql.toString(), args))
					.toString());
		}
		long cur = System.currentTimeMillis();
		try {
			return namedjdbc.queryForList(sql.toString(), args);
		} catch (Exception e) {
			throw new CapDBException(e, causeClass);
		} finally {
			logger.info("CapNamedJdbcTemplate spend {} ms",
					(System.currentTimeMillis() - cur));
		}
	}// ;

	public Page<Map<String, Object>> queryForPage(String sqlId,
			Map<String, Object> args, int startRow, int fetchSize) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(CapJdbcContants.SQLPaging_SourceSQL,
				sqlp.getValue(sqlId, sqlId));
		StringBuffer sql = new StringBuffer().append(CapDbUtil.spelParser(
				(String) sqltemp.getValue(CapJdbcContants.SQLPaging_TotalPage),
				params, sqlp.getParserContext()));
		sql.append(' ').append(
				sqltemp.getValue(CapJdbcContants.SQLQuery_Suffix, ""));
		if (logger.isTraceEnabled()) {
			logger.trace(new StringBuffer("\n\t").append(
					CapDbUtil.convertToSQLCommand(sql.toString(), args))
					.toString());
		}
		// find list
		List<Map<String, Object>> list = this.queryPaging(sqlId, args,
				startRow, fetchSize);
		long cur = System.currentTimeMillis();
		try {
			return new Page<Map<String, Object>>(list, namedjdbc.queryForInt(
					sql.toString(), args), fetchSize, startRow);
		} catch (Exception e) {
			throw new CapDBException(e, causeClass);
		} finally {
			logger.info("CapNamedJdbcTemplate spend {} ms",
					(System.currentTimeMillis() - cur));
		}
	}// ;

	public Page<Map<String, Object>> queryForPage(String sqlId, ISearch search) {
		CapSqlSearchQueryProvider provider = new CapSqlSearchQueryProvider(
				search);
		String _sql = sqlp.getValue(sqlId, sqlId);
		StringBuffer sourceSql = new StringBuffer(_sql).append(
				_sql.toUpperCase().lastIndexOf("WHERE") > 0 ? " AND "
						: " WHERE ").append(provider.generateWhereCause());
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(CapJdbcContants.SQLPaging_SourceSQL, sourceSql.toString());
		// 準備查詢筆數sql
		StringBuffer sql = new StringBuffer().append(CapDbUtil.spelParser(
				(String) sqltemp.getValue(CapJdbcContants.SQLPaging_TotalPage),
				params, sqlp.getParserContext()));
		sql.append(' ').append(
				sqltemp.getValue(CapJdbcContants.SQLQuery_Suffix, ""));
		if (logger.isTraceEnabled()) {
			logger.trace(new StringBuffer("\n\t").append(
					CapDbUtil.convertToSQLCommand(sql.toString(),
							provider.getParams())).toString());
		}
		String sqlRow = sql.toString();
		// 準備查詢list sql
		sourceSql.append(provider.generateOrderCause());
		params.put(CapJdbcContants.SQLPaging_SourceSQL, sourceSql.toString());
		sql = new StringBuffer().append(CapDbUtil.spelParser(
				(String) sqltemp.getValue(CapJdbcContants.SQLPaging_Query),
				params, sqlp.getParserContext()));
		sql.append(' ').append(
				sqltemp.getValue(CapJdbcContants.SQLQuery_Suffix, ""));
		if (logger.isTraceEnabled()) {
			logger.trace(new StringBuffer("\n\t").append(
					CapDbUtil.convertToSQLCommand(sql.toString(),
							provider.getParams())).toString());
		}
		long cur = System.currentTimeMillis();
		try {
			int totalRows = namedjdbc.queryForInt(sqlRow, provider.getParams());
			List<Map<String, Object>> list = namedjdbc.queryForList(
					sql.toString(), provider.getParams());
			return new Page<Map<String, Object>>(list, totalRows,
					search.getMaxResults(), search.getFirstResult());
		} catch (Exception e) {
			throw new CapDBException(e, causeClass);
		} finally {
			logger.info("CapNamedJdbcTemplate spend {} ms",
					(System.currentTimeMillis() - cur));
		}
	}// ;

	public <T> Page<T> queryForPage(String sqlId, ISearch search,
			RowMapper<T> rm) {
		CapSqlSearchQueryProvider provider = new CapSqlSearchQueryProvider(
				search);
		String _sql = sqlp.getValue(sqlId, sqlId);
		StringBuffer sourceSql = new StringBuffer(_sql).append(
				_sql.toUpperCase().lastIndexOf("WHERE") > 0 ? " AND "
						: " WHERE ").append(provider.generateWhereCause());
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(CapJdbcContants.SQLPaging_SourceSQL, sourceSql.toString());
		// 準備查詢筆數sql
		StringBuffer sql = new StringBuffer().append(CapDbUtil.spelParser(
				(String) sqltemp.getValue(CapJdbcContants.SQLPaging_TotalPage),
				params, sqlp.getParserContext()));
		sql.append(' ').append(
				sqltemp.getValue(CapJdbcContants.SQLQuery_Suffix, ""));
		if (logger.isTraceEnabled()) {
			logger.trace(new StringBuffer("\n\t").append(
					CapDbUtil.convertToSQLCommand(sql.toString(),
							provider.getParams())).toString());
		}
		String sqlRow = sql.toString();
		// 準備查詢list sql
		sourceSql.append(provider.generateOrderCause());
		params.put(CapJdbcContants.SQLPaging_SourceSQL, sourceSql.toString());
		sql = new StringBuffer().append(CapDbUtil.spelParser(
				(String) sqltemp.getValue(CapJdbcContants.SQLPaging_Query),
				params, sqlp.getParserContext()));
		sql.append(' ').append(
				sqltemp.getValue(CapJdbcContants.SQLQuery_Suffix, ""));
		if (logger.isTraceEnabled()) {
			logger.trace(new StringBuffer("\n\t").append(
					CapDbUtil.convertToSQLCommand(sql.toString(),
							provider.getParams())).toString());
		}
		long cur = System.currentTimeMillis();
		try {
			int totalRows = namedjdbc.queryForInt(sqlRow, provider.getParams());
			List<T> list = namedjdbc.query(sql.toString(),
					provider.getParams(), rm);
			return new Page<T>(list, totalRows, search.getMaxResults(),
					search.getFirstResult());
		} catch (Exception e) {
			throw new CapDBException(e, causeClass);
		} finally {
			logger.info("CapNamedJdbcTemplate spend {} ms",
					(System.currentTimeMillis() - cur));
		}
	}// ;

}// ~
