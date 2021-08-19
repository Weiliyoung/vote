package com.weiyang.vote.domain.pojo;

import java.util.Date;

public class Vote {
    private Integer id;

    private String wechatId;

    private String title;

    private String description;

    private Integer type;

    private Integer status;

    private Date cutOffTime;

    private Date createTime;

    private Date updateTime;

    private String picUrl;

    public Vote(Integer id, String wechatId, String title, String description, Integer type, Integer status, Date cutOffTime, Date createTime, Date updateTime) {
        this.id = id;
        this.wechatId = wechatId;
        this.title = title;
        this.description = description;
        this.type = type;
        this.status = status;
        this.cutOffTime = cutOffTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Vote(Integer id, String wechatId, String title, String description, Integer type, Integer status, Date cutOffTime, Date createTime, Date updateTime, String picUrl) {
        this.id = id;
        this.wechatId = wechatId;
        this.title = title;
        this.description = description;
        this.type = type;
        this.status = status;
        this.cutOffTime = cutOffTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.picUrl = picUrl;
    }

    public Vote() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId == null ? null : wechatId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCutOffTime() {
        return cutOffTime;
    }

    public void setCutOffTime(Date cutOffTime) {
        this.cutOffTime = cutOffTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }
}