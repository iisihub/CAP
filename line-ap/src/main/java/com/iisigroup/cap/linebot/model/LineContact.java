package com.iisigroup.cap.linebot.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.iisigroup.cap.db.model.DataObject;
import com.iisigroup.cap.db.model.listener.CapOidGeneratorListener;
import com.iisigroup.cap.model.GenericBean;

@SuppressWarnings("serial")
@Entity
@EntityListeners({ CapOidGeneratorListener.class })
@Table(name = "LINE_CONTACT", uniqueConstraints = @UniqueConstraint(columnNames = { "mid" }))
public class LineContact extends GenericBean implements DataObject {
    @Id
    @Column(nullable = false, length = 32)
    private String oid;
    // 顯示名稱
    @Column(length = 20, columnDefinition = "NVARCHAR(20)")
    private String diaplayName;
    // LINE ID
    @Column(length = 100, columnDefinition = "VARCHAR(100)")
    private String mid;
    // 頭像的 URL
    @Column(length = 256, columnDefinition = "VARCHAR(256)")
    private String pictureUrl;
    // 頭像圖片 base64
    @Column(columnDefinition = "VARCHAR(MAX)")
    private String picture;
    // 狀態訊息
    @Column(length = 500, columnDefinition = "NVARCHAR(500)")
    private String statusMessage;
    // 是否 Block，0否，1是
    @Column(length = 1, columnDefinition = "CHAR(1)")
    private String blocked;
    // Block 的時間
    @Column
    private Timestamp blockedTime;
    // 加入好友的時間
    @Column
    private Timestamp addTime;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getDiaplayName() {
        return diaplayName;
    }

    public void setDiaplayName(String diaplayName) {
        this.diaplayName = diaplayName;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getBlocked() {
        return blocked;
    }

    public void setBlocked(String blocked) {
        this.blocked = blocked;
    }

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Timestamp getBlockedTime() {
        return blockedTime;
    }

    public void setBlockedTime(Timestamp blockedTime) {
        this.blockedTime = blockedTime;
    }

}
