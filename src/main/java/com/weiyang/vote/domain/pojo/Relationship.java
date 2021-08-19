package com.weiyang.vote.domain.pojo;

import java.util.Date;

public class Relationship extends RelationshipKey {
    private Date createTime;

    public Relationship(Integer userId, Integer voteId, Integer voteOptionId, Date createTime) {
        super(userId, voteId, voteOptionId);
        this.createTime = createTime;
    }

    public Relationship() {
        super();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Relationship{" +
                super.toString() +
                "createTime=" + createTime +
                '}';
    }
}