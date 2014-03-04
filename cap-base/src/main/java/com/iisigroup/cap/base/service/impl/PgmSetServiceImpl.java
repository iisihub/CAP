package com.iisigroup.cap.base.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.iisigroup.cap.base.dao.CodeItemDao;
import com.iisigroup.cap.base.model.CodeItem;
import com.iisigroup.cap.base.service.PgmSetService;
import com.iisigroup.cap.dao.utils.ISearch;
import com.iisigroup.cap.jdbc.CapNamedJdbcTemplate;
import com.iisigroup.cap.model.Page;
import com.iisigroup.cap.service.AbstractService;
import com.iisigroup.cap.utils.CapString;

/**
 * <pre>
 * 系統功能維護
 * </pre>
 * 
 * @since 2014/1/16
 * @author tammy
 * @version <ul>
 *          <li>2014/1/16,tammy,new
 *          </ul>
 */
@Service("pgmSetService")
public class PgmSetServiceImpl extends AbstractService implements PgmSetService {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PgmSetServiceImpl.class);

	@Resource
	private CodeItemDao dao;

	private CapNamedJdbcTemplate jdbc;

	public void setJdbc(CapNamedJdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public CodeItem find(String code) {
		if (!CapString.isEmpty(code)) {
			return dao.find(Integer.parseInt(code));
		}
		return null;
	}

	@Override
	public List<CodeItem> findBySystypAndStep(String systyp, String step) {
		return dao.findBySystypAndStep(systyp, step);
	}

	@Override
	public void savePgm(CodeItem model) {
		deleteRlf(Integer.toString(model.getCode()));
		
		dao.save(model);
	}

	@Override
	public Page<Map<String, Object>> findPage(ISearch search, String systyp,
			String pgmCode) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("systyp", systyp);
		param.put("pgmCode", pgmCode);

		return jdbc.queryForPage("pamSet_role", param, search.getFirstResult(),
				search.getMaxResults());
	}
	
	@Override
	public List<Map<String, Object>> findAllRole(String systyp){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("systyp", systyp);

		return jdbc.query("pamSet_AllRole", param);
	}
	
//	@Override
	public void deleteRlf(String pgmCode) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("pgmCode", pgmCode);

		jdbc.update("pamSet_delRlf", param);
	}
}
