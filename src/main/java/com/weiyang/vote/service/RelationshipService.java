package com.weiyang.vote.service;

import com.weiyang.vote.domain.pojo.Relationship;

import java.util.List;


public interface RelationshipService {
    boolean createRelationship(Relationship relationship);

    int getChoicesStats(Integer voteId, Integer voteOptionId);

    List<Integer> getMyJoinedVoteIdListByUserId(Integer userId);
}