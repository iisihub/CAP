package com.iisigroup.cap.auth.support;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iisigroup.cap.auth.model.Function;

/**
 * <pre>
 * CodeItem RowMapper
 * </pre>
 * 
 * @since 2014/4/30
 * @author Lancelot
 * @version
 *          <ul>
 *          <li>2014/4/30,Lancelot,new
 *          </ul>
 */
public class FunctionRowMapper implements RowMapper<Function> {

    @Override
    public Function mapRow(ResultSet rs, int rowNum) throws SQLException {
        Function item = new Function();
        item.setCode(rs.getInt("CODE"));
        item.setSysType(rs.getString("SYSTYPE"));
        item.setSequence(rs.getInt("SEQUENCE"));
        item.setLevel(rs.getInt("LEVEL"));
        item.setParent(rs.getInt("PARENT"));
        item.setName(rs.getString("NAME"));
        item.setPath(rs.getString("PATH"));
        item.setDesc(rs.getString("DESC"));
        item.setStatus(rs.getString("STATUS"));
        item.setUpdater(rs.getString("UPDATER"));
        item.setUpdateTime(rs.getTimestamp("UPDATETIME"));
        return item;
    }

}
