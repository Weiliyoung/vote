package com.weiyang.vote.service.impl;

import com.weiyang.vote.domain.pojo.Relationship;
import com.weiyang.vote.domain.pojo.RelationshipKey;
import com.weiyang.vote.mapper.RelationshipMapper;
import com.weiyang.vote.service.RelationshipService;
import com.weiyang.vote.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RelationshipServiceImpl implements RelationshipService {
    private static final Logger logger = Logger.getLogger(RelationshipServiceImpl.class);

    @Override
    public boolean createRelationship(Relationship relationship) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        RelationshipMapper relationshipMapper = sqlSession.getMapper(RelationshipMapper.class);
        RelationshipKey relationshipKey = new RelationshipKey();
        relationshipKey.setVoteId(relationshipKey.getVoteId());
        relationshipKey.setUserId(relationshipKey.getUserId());
        relationshipKey.setVoteOptionId(relationshipKey.getVoteOptionId());
        int result = relationshipMapper.insert(relationship);
        logger.info("哪个用户创建投票：" + relationship.toString());
        logger.info("投票ID：" + Integer.valueOf(result));
        logger.info("选项ID：" + Integer.valueOf(relationship.getVoteOptionId()));
        sqlSession.commit();
        sqlSession.close();
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getChoicesStats(Integer voteId, Integer voteOptionId) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        RelationshipMapper relationshipMapper = sqlSession.getMapper(RelationshipMapper.class);
        RelationshipKey relationshipKey = new RelationshipKey();
        relationshipKey.setVoteId(voteId);
        relationshipKey.setVoteOptionId(voteOptionId);
        int choicesStats = relationshipMapper.selectCountByVoteIdAndVoteOptionId(relationshipKey);
        logger.info("获取投票选项的统计结果成功，结果为：" + choicesStats);
        return choicesStats;
    }

    @Override
    public List<Integer> getMyJoinedVoteIdListByUserId(Integer userId) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        RelationshipMapper relationshipMapper = sqlSession.getMapper(RelationshipMapper.class);
        RelationshipKey relationshipKey = new RelationshipKey();
        relationshipKey.setUserId(userId);
        List<RelationshipKey> relationshipKeyList = relationshipMapper.selectVoteIdByUserId(userId);
        List<Integer> voteIdList = new ArrayList<>();
        for (RelationshipKey relationship : relationshipKeyList) {
            voteIdList.add(relationship.getVoteId());
        }
        logger.info("我参与的VoteId：" + voteIdList);
        return voteIdList;
    }
}

