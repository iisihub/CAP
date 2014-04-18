package com.iisigroup.cap.base.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.jdbc.core.RowCallbackHandler;

import com.iisigroup.cap.base.dao.CodeItemDao;
import com.iisigroup.cap.base.model.CodeItem;
import com.iisigroup.cap.base.service.CodeItemService;
import com.iisigroup.cap.jdbc.CapNamedJdbcTemplate;
import com.iisigroup.cap.utils.StringUtil;

//@Service
public class CodeItemServiceImpl implements CodeItemService {

	@Resource
	private CodeItemDao dao;

	private static final int NO_PARENT = -1;

	private Map<Integer, CodeItem> codes = new ConcurrentHashMap<Integer, CodeItem>();
	private Map<String, Set<Integer>> roleSteps = new ConcurrentHashMap<String, Set<Integer>>();
	private Map<String, List<CodeItem>> roleStepCodes = new ConcurrentHashMap<String, List<CodeItem>>();
	// private Map<String, List<CodeItem>> urlCodes = new
	// ConcurrentHashMap<String, List<CodeItem>>();
	private Map<String, Map<Integer, Integer>> roleAuthes = new ConcurrentHashMap<String, Map<Integer, Integer>>();

	private String systemType;

	private CapNamedJdbcTemplate jdbc;

	public void setJdbc(CapNamedJdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}

	public CodeItemServiceImpl() {
		super();
	}

	@PostConstruct
	public void init() {
		codes.clear();
		roleSteps.clear();
		roleStepCodes.clear();
		// urlCodes.clear();

		initCode();
		initCodeRelation();
	}

	void initCode() {
		List<CodeItem> list = dao.findAll(systemType);
		for (CodeItem item : list) {
			codes.put(item.getCode(), item);
		}
	}

	void initCodeRelation() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("system", systemType);

		jdbc.query("Role.auth", param, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				String role = StringUtil.trim(rs.getString("ROLE"));
				Map<Integer, Integer> authes = roleAuthes.get(role);
				if (authes == null) {
					authes = new HashMap<Integer, Integer>();
					roleAuthes.put(role, authes);
				}
				authes.put(rs.getInt("AUTHCODE"), rs.getInt("AUTHCODE"));
			}
		});

		for (Entry<String, Map<Integer, Integer>> entry : roleAuthes.entrySet()) {
			String role = entry.getKey();
			Set<Integer> steps = roleSteps.get(role);
			if (steps == null) {
				steps = new HashSet<Integer>();
				roleSteps.get(steps);
			}
			for (Integer auth : entry.getValue().keySet()) {
				CodeItem code = codes.get(auth);
				if (code == null)
					continue;
				String key = getRoleStepKey(role, code.getStep());
				List<CodeItem> stepCodes = roleStepCodes.get(key);
				if (stepCodes == null) {
					stepCodes = new LinkedList<CodeItem>();
					roleStepCodes.put(key, stepCodes);
				}
				stepCodes.add(code);
				steps.add(code.getStep());
			}
			roleSteps.put(role, steps);
		}
	}

	private String getRoleStepKey(String role, int step) {
		return role + "_" + step;
	}

	@Override
	public List<CodeItem> findByStep(Set<String> roles, int... step) {
		return findByParentAndSteps(roles, NO_PARENT, step);
	}

	@Override
	public List<CodeItem> findByParent(Set<String> roles, int parent) {
		int step = codes.get(parent).getStep() + 1;
		return findByParentAndSteps(roles, parent, new int[] { step });
	}

	public List<CodeItem> findByParentAndSteps(Set<String> roles, int parent,
			int... steps) {

		Set<Integer> pSet = new HashSet<Integer>();
		pSet.add(parent);

		Set<CodeItem> set = new HashSet<CodeItem>();
		if (roles == null) {
			roles = Collections.emptySet();
		}
		Arrays.sort(steps);

		for (String role : roles) {
			for (int step : steps) {
				String key = getRoleStepKey(role, step);
				List<CodeItem> stepCodes = roleStepCodes.get(key);

				if (stepCodes == null) {
					continue;
				} else if (parent == NO_PARENT) {
					set.addAll(stepCodes);
					for (CodeItem code : stepCodes) {
						pSet.add(code.getCode());
					}
				} else {
					for (CodeItem code : stepCodes) {
						if (pSet.contains(code.getParent())) {
							set.add(code);
							pSet.add(code.getCode());
						}
					}
				}
			}
		}
		return Arrays.asList(set.toArray(new CodeItem[set.size()]));
	}
	
	@Override
	public CodeItem getCodeItemByCode(int code) {
		return codes.get(code);
	}
	
	@Override
	public List<CodeItem> findByParentAndSteps(String pgmDept,
			Set<String> roles, int parent, int... steps) {

		Set<Integer> pSet = new HashSet<Integer>();
		pSet.add(parent);

		Set<CodeItem> set = new HashSet<CodeItem>();
		if (roles == null) {
			roles = Collections.emptySet();
		}
		Arrays.sort(steps);

		for (String role : roles) {
			for (int step : steps) {
				String key = getRoleStepKey(role, step);
				List<CodeItem> stepCodes = roleStepCodes.get(key);

				if (stepCodes == null) {
					continue;
				} else if (parent == NO_PARENT) {
					set.addAll(stepCodes);
					for (CodeItem code : stepCodes) {
						// ************************
//						if (!isPGMDeptCheckOK(roleAuthDepts, role,
//								code.getCode(), pgmDept)) {
//							continue;
//						}
						// ************************
						pSet.add(code.getCode());

					}
				} else {
					for (CodeItem code : stepCodes) {
						// ************************
//						if (!isPGMDeptCheckOK(roleAuthDepts, role,
//								code.getCode(), pgmDept)) {
//							continue;
//						}
						// ************************
						if (pSet.contains(code.getParent())) {
							set.add(code);
							pSet.add(code.getCode());
						}
					}
				}
			}
		}
		return Arrays.asList(set.toArray(new CodeItem[set.size()]));
	}
}
