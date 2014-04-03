package com.iisigroup.cap.base.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.iisigroup.cap.base.dao.SequenceDao;
import com.iisigroup.cap.base.model.Sequence;
import com.iisigroup.cap.dao.impl.GenericDao;
import com.iisigroup.cap.model.Page;

@Repository
public class SequenceDaoImpl extends GenericDao<Sequence> implements
		SequenceDao {

	@Override
	public Page<Map<String, Object>> listAllForPaging(int start, int fetch) {
		return getNamedJdbcTemplate().queryForPage("Sequence.listAll", null,
				start, fetch);
	}

	@Override
	public void createFromMap(Map<String, Object> map) {
		getNamedJdbcTemplate().update("Sequence.insert", map);
	}

	@Override
	public int updateByNodeAndNextSeqFromMap(Map<String, Object> map) {
		return getNamedJdbcTemplate().update("Sequence.updateByNodeAndNextSeq",
				map);
	}

	@Override
	public Sequence findBySeqNode(String seqNode) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("seqNode", seqNode);
		return getNamedJdbcTemplate().queryForObject("Sequence.findBySeqNode", args,
				new RowMapper<Sequence>() {
			@Override
			public Sequence mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Sequence seq = new Sequence();
				seq.setSeqNode(rs.getString("SEQNODE"));
				seq.setNextSeq(rs.getInt("NEXTSEQ"));
				seq.setRounds(rs.getInt("ROUNDS"));
				seq.setUpdateTime(rs.getTimestamp("UPDATETIME"));
				return seq;
			}
		});
	}

}
