package com.iisigroup.cap.auth.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.model.IDataObject;
import com.iisigroup.cap.model.listener.CapOidGeneratorListener;

/**
 * 權限物件
 */
@SuppressWarnings("serial")
@EntityListeners({ CapOidGeneratorListener.class })
@Entity
@Table(name = "DEF_FUNC", uniqueConstraints = @UniqueConstraint(columnNames = { "OID" }))
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "P")
public class Function extends GenericBean implements IDataObject {

    /** 權限代碼 **/
    @Id
    private String oid;

    @Column
    private int code;

    /** 功能隸屬系統別 **/
    @Column
    private String sysType;

    /** 排列順序 **/
    @Column
    private int sequence;

    /** 權限階層 **/
    @Column
    private int level;

    /** 權限上層代碼 **/
    @Column
    private int parent;

    /** 代碼名稱 **/
    @Column
    private String name;

    /** URL位置 **/
    @Column
    private String path;

    /** DESC **/
    @Column
    private String desc;

    /** 是否啟用 **/
    @Column
    private String status;

    @Column(length = 10)
    private String updater;

    @Column(columnDefinition = "TIMESTAMP")
    private Timestamp updateTime;

    @OneToMany(mappedBy = "function", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoleFunction> rfList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String toString() {
        return "Function [code=" + code + ", sequence=" + sequence + ", level=" + level
                + ", parent=" + parent + ", name=" + name + ", path=" + path
                + "]";
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + code;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + parent;
        result = prime * result + sequence;
        result = prime * result + level;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Function other = (Function) obj;
        if (code != other.code)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (parent != other.parent)
            return false;
        if (sequence != other.sequence)
            return false;
        if (level != other.level)
            return false;

        if (path == null) {
            if (other.path != null)
                return false;
        } else if (!path.equals(other.path))
            return false;

        return true;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<RoleFunction> getRfList() {
        return rfList;
    }

    public void setRfList(List<RoleFunction> rfList) {
        this.rfList = rfList;
    }

    public String getSysType() {
        return sysType;
    }

    public void setSysType(String sysType) {
        this.sysType = sysType;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
}
