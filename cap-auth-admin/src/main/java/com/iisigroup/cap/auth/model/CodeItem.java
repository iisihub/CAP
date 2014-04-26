package com.iisigroup.cap.auth.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.iisigroup.cap.model.GenericBean;

/**
 * 權限物件
 */
@Entity
@Table(name = "DEF_PGM", uniqueConstraints = @UniqueConstraint(columnNames = { "PGMCODE" }))
public class CodeItem extends GenericBean {

	/** 權限代碼 **/
	@Id
	@Column(name = "PGMCODE")
	private int code;

	/** 功能隸屬系統別 **/
	private String sysTyp;

	/** 排列順序 **/
	@Column(name = "SEQ")
	private int seq;

	/** 權限階層 **/
	@Column(name = "PGMTYPE")
	private int step;

	/** 權限上層代碼 **/
	@Column(name = "PGMTYP")
	private int parent;

	/** 代碼名稱 **/
	@Column(name = "PGMNAME")
	private String name;

	/** URL位置 **/
	@Column(name = "PGMPATH")
	private String path;

	/** 權限選項 **/
	// @Column(name="PGMAUTH")
	// private String auth;

	/** DESC **/
	@Column(name = "PGMDESC")
	private String desc;

	/** 文件ID **/
	private String docid;

	/** 是否啟用 **/
	private String inputFlg;

	@Column(length = 6)
	private String updater;

	@Column(columnDefinition = "TIMESTAMP")
	private Timestamp updateTime;

	@OneToMany(mappedBy = "pgm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<RoleFunction> rlfList;

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

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getStep() {
		return step;
	}

	public String toString() {
		return "CodeItemImpl [code=" + code + ", seq=" + seq + ", step=" + step
				+ ", parent=" + parent + ", name=" + name + ", path=" + path
				+ "]";
	}

	public void setStep(int step) {
		this.step = step;
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
		result = prime * result + seq;
		result = prime * result + step;
		// result = prime * result + ((path == null) ? 0 : path.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CodeItem other = (CodeItem) obj;
		if (code != other.code)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parent != other.parent)
			return false;
		if (seq != other.seq)
			return false;
		if (step != other.step)
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

	public String getDocid() {
		return docid;
	}

	public void setDocid(String docid) {
		this.docid = docid;
	}

	public String getSysTyp() {
		return sysTyp;
	}

	public void setSysTyp(String sysTyp) {
		this.sysTyp = sysTyp;
	}

	// public String getAuth() {
	// return auth;
	// }
	//
	// public void setAuth(String auth) {
	// this.auth = auth;
	// }

	public String getInputFlg() {
		return inputFlg;
	}

	public void setInputFlg(String inputFlg) {
		this.inputFlg = inputFlg;
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

	public List<RoleFunction> getRlfList() {
		return rlfList;
	}

	public void setRlfList(List<RoleFunction> rlfList) {
		this.rlfList = rlfList;
	}
}
