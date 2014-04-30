package com.iisigroup.cap.auth.support;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iisigroup.cap.auth.model.CodeItem;

/**
 * <pre>
 * CodeItem RowMapper
 * </pre>
 * 
 * @since 2014/4/30
 * @author Lancelot
 * @version <ul>
 *          <li>2014/4/30,Lancelot,new
 *          </ul>
 */
public class CodeItemRowMapper implements RowMapper<CodeItem> {

    @Override
    public CodeItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        CodeItem item = new CodeItem();
        item.setCode(rs.getInt("PGMCODE"));
        item.setSysTyp(rs.getString("SYSTYP"));
        item.setSeq(rs.getInt("SEQ"));
        item.setStep(rs.getInt("PGMTYPE"));
        item.setParent(rs.getInt("PGMTYP"));
        item.setName(rs.getString("PGMNAME"));
        item.setPath(rs.getString("PGMPATH"));
        item.setDesc(rs.getString("PGMDESC"));
        item.setDocid(rs.getString("DOCID"));
        item.setInputFlg(rs.getString("INPUTFLG"));
        item.setUpdater(rs.getString("UPDATER"));
        item.setUpdateTime(rs.getTimestamp("UPDATETIME"));
        return item;
    }

}
