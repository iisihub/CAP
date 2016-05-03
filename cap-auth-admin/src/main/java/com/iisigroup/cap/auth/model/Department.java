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
import javax.validation.constraints.NotNull;

import com.iisigroup.cap.model.DataObject;
import com.iisigroup.cap.model.GenericBean;
import com.iisigroup.cap.model.listener.CapOidGeneratorListener;

/**
 * <pre>
 * 分行資訊
 * </pre>
 * 
 * @since 2013/12/26
 * @author tammy
 * @version
 *          <ul>
 *          <li>2013/12/26,tammy,new
 *          <li>2014/5/15, Lancelot, update model/table/variable name
 *          </ul>
 */
@Entity
@EntityListeners({ CapOidGeneratorListener.class })
@Table(name = "DEF_DEP", uniqueConstraints = @UniqueConstraint(columnNames = { "oid" }))
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "P")
public class Department extends GenericBean implements DataObject {
    private static final long serialVersionUID = 1L;

    @Id
    private String oid;

    @NotNull
    @Column(nullable = false, length = 4, columnDefinition = "CHAR(4)")
    private String code;

    @Column(length = 30)
    private String name;

    @Column(length = 1)
    private String level;

    @Column(length = 20)
    private String tel;

    @Column(length = 5)
    private String zip;

    @Column(length = 90)
    private String addr;

    @Column(length = 4)
    private String division;

    @Column(length = 30)
    private String manager;

    @Column(length = 30)
    private String proxy;

    @Column(length = 4)
    private String bizGroup;

    @Column(length = 2)
    private String country;

    @Column(length = 9)
    private String timeZone;

    @Column(length = 1)
    private String status;

    @Column(length = 10)
    private String updater;

    @Column
    private Timestamp updateTime;

    @OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<DefaultUser> users;

    public Department() {
    }

    public Department(String code) {
        this.setCode(code);
    }

    public String getOid() {
        return this.oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getUpdater() {
        return this.updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public List<DefaultUser> getUsers() {
        return this.users;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[Def_depVo:");
        buffer.append(" oid: ");
        buffer.append(oid);
        buffer.append(" code: ");
        buffer.append(code);
        buffer.append(" name: ");
        buffer.append(name);
        buffer.append(" level: ");
        buffer.append(level);
        buffer.append(" tel: ");
        buffer.append(tel);
        buffer.append(" zip: ");
        buffer.append(zip);
        buffer.append(" addr: ");
        buffer.append(addr);
        buffer.append(" division: ");
        buffer.append(division);
        buffer.append(" manager: ");
        buffer.append(manager);
        buffer.append(" proxy: ");
        buffer.append(proxy);
        buffer.append(" bizGroup: ");
        buffer.append(bizGroup);
        buffer.append(" country: ");
        buffer.append(country);
        buffer.append(" timeZone: ");
        buffer.append(timeZone);
        buffer.append(" status: ");
        buffer.append(status);
        buffer.append(" updater: ");
        buffer.append(updater);
        buffer.append(" updateTime: ");
        buffer.append(updateTime);
        buffer.append("]");
        return buffer.toString();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public String getBizGroup() {
        return bizGroup;
    }

    public void setBizGroup(String bizGroup) {
        this.bizGroup = bizGroup;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

}
