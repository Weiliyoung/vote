package com.weiyang.vote.domain.pojo;

public class RelationshipKey {
    private Integer userId;

    private Integer voteId;

    private Integer voteOptionId;

    public RelationshipKey(Integer userId, Integer voteId, Integer voteOptionId) {
        this.userId = userId;
        this.voteId = voteId;
        this.voteOptionId = voteOptionId;
    }

    public RelationshipKey() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public Integer getVoteOptionId() {
        return voteOptionId;
    }

    public void setVoteOptionId(Integer voteOptionId) {
        this.voteOptionId = voteOptionId;
    }

    @Override
    public String toString() {
        return "userId=" + userId +
                ", voteId=" + voteId +
                ", voteOptionId=" + voteOptionId + ",";
    }

}