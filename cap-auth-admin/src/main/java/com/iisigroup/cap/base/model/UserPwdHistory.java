package com.iisigroup.cap.base.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.model.IDataObject;
import com.iisigroup.cap.model.listener.CapOidGeneratorListener;

/**
 * <pre>
 * User 密碼歷史資訊
 * </pre>
 * 
 * @since 2014/01/27
 * @author yunglinliu
 * @version <ul>
 *          <li>2014/01/27,yunglinliu,new</li>
 *          </ul>
 */
@SuppressWarnings("serial")
@Entity
@EntityListeners({ CapOidGeneratorListener.class })
@Table(name = "DEF_USER_PWD_HISTORY")
public class UserPwdHistory extends GenericBean implements IDataObject {

    @Id
    @Column(nullable = false, length = 32)
    private String oid;
    @NotNull
    @Column(length = 32)
    private String userOid;
    @NotNull
    @Column(length = 100)
    private String password;
    @Column
    private Timestamp updateTime;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserOid() {
        return userOid;
    }

    public void setUserOid(String userOid) {
        this.userOid = userOid;
    }
}
