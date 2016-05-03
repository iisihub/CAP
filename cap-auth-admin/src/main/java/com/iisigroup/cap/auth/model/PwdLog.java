package com.iisigroup.cap.auth.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.iisigroup.cap.model.DataObject;
import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.model.listener.CapOidGeneratorListener;

/**
 * <pre>
 * User 密碼歷史資訊
 * </pre>
 * 
 * @since 2014/01/27
 * @author yunglinliu
 * @version
 *          <ul>
 *          <li>2014/01/27,yunglinliu,new</li>
 *          </ul>
 */
@SuppressWarnings("serial")
@Entity
@EntityListeners({ CapOidGeneratorListener.class })
@Table(name = "DEF_PWDLOG")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "P")
public class PwdLog extends GenericBean implements DataObject {

    @Id
    @Column(nullable = false, length = 32)
    private String oid;
    @NotNull
    @Column(length = 10)
    private String userCode;
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

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
