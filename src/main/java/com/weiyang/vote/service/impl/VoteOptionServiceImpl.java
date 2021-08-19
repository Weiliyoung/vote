package com.weiyang.vote.service.impl;

import com.weiyang.vote.domain.pojo.VoteOption;
import com.weiyang.vote.mapper.RelationshipMapper;
import com.weiyang.vote.mapper.VoteOptionMapper;
import com.weiyang.vote.service.VoteOptionService;
import com.weiyang.vote.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;

public class VoteOptionServiceImpl implements VoteOptionService {
    private static final Logger logger = Logger.getLogger(VoteOptionServiceImpl.class);

    @Override
    public boolean createVoteOption(VoteOption voteOption) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        VoteOptionMapper voteOptionMapper = sqlSession.getMapper(VoteOptionMapper.class);
        int result = voteOptionMapper.insertSelective(voteOption);
        logger.info("新增用户信息: " + voteOption.toString());
        logger.info("影响有效结果: " + String.valueOf(result));
        logger.info("新建用户ID: " + String.valueOf(voteOption));
        sqlSession.commit();
        sqlSession.close();
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<VoteOption> getVoteOptionIdsList(Integer voteId) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        VoteOptionMapper voteOptionMapper = sqlSession.getMapper(VoteOptionMapper.class);
        return voteOptionMapper.selectIdsListByVoteId(voteId);
    }

    @Override
    public List<VoteOption> getVoteOptionList(Integer voteId) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        VoteOptionMapper voteOptionMapper = sqlSession.getMapper(VoteOptionMapper.class);
        List<VoteOption> voteOptionList = voteOptionMapper.selectListByVoteId(voteId);
        for (VoteOption voteOption : voteOptionList) {
            logger.info(voteOption.toString());
        }
        return voteOptionList;
    }
}
