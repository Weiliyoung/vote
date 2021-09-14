package com.weiyang.vote.mapper;

import com.weiyang.vote.domain.pojo.Relationship;
import com.weiyang.vote.domain.pojo.RelationshipKey;
import org.apache.ibatis.javassist.runtime.Inner;

import java.util.List;

public interface RelationshipMapper {
    int deleteByPrimaryKey(RelationshipKey key);

    int insert(Relationship record);

    int insertSelective(Relationship record);

    Relationship selectByPrimaryKey(RelationshipKey key);

    int selectCountByVoteIdAndVoteOptionId(RelationshipKey relationshipKey);

    int updateByPrimaryKeySelective(Relationship record);

    int updateByPrimaryKey(Relationship record);

    List<RelationshipKey> selectVoteIdByUserId(Integer userId);
}