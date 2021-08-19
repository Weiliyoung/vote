package com.weiyang.vote.domain.vo;

import java.util.List;
import java.util.Map;

public class VoteResponse {

    private Integer id;

    private String wechatId;

    private String title;

    private String description;

    private Integer type;

    private Integer status;

    private String cutOffTime;

    private String createTime;

    private String updateTime;

    private String picUrl;

    private List<Map<String, String>> voteOptionItemList;

    public VoteResponse(Integer id, String wechatId, String title, String description, Integer type, Integer status, String cutOffTime, String createTime, String updateTime, String picUrl, List<Map<String, String>> voteOptionItemList) {
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
        this.voteOptionItemList = voteOptionItemList;
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
        this.wechatId = wechatId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getCutOffTime() {
        return cutOffTime;
    }

    public void setCutOffTime(String cutOffTime) {
        this.cutOffTime = cutOffTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public List<Map<String, String>> getVoteOptionItemList() {
        return voteOptionItemList;
    }

    public void setVoteOptionItemList(List<Map<String, String>> voteOptionItemList) {
        this.voteOptionItemList = voteOptionItemList;
    }

    @Override
    public String toString() {
        return "VoteResponse{" +
                "id=" + id +
                ", wechatId='" + wechatId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", cutOffTime='" + cutOffTime + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", voteOptionItemList=" + voteOptionItemList +
                '}';
    }
}
