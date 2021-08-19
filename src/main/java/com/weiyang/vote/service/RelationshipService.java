package com.weiyang.vote.service;

import com.weiyang.vote.domain.pojo.Relationship;


public interface RelationshipService {
    boolean createRelationship(Relationship relationship);

    int getChoicesStats(Integer voteId, Integer voteOptionId);
}