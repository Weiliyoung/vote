package com.weiyang.vote.service.impl;

import com.weiyang.vote.domain.pojo.Vote;
import com.weiyang.vote.mapper.VoteMapper;
import com.weiyang.vote.service.VoteService;
import com.weiyang.vote.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;

public class VoteServiceImpl implements VoteService {

    private static final Logger logger = Logger.getLogger(VoteOptionServiceImpl.class);


    @Override
    public boolean createVote(Vote vote) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        VoteMapper voteMapper = sqlSession.getMapper(VoteMapper.class);
        int result = voteMapper.insert(vote);
        logger.info("新增文字投票: " + vote.toString());
        logger.info("影响有效结果: " + String.valueOf(result));
        logger.info("新建投票ID: " + String.valueOf(vote.getWechatId()));
        sqlSession.commit();
        sqlSession.close();
        if (result == 1) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Vote getVoteInfo(Integer voteId) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        VoteMapper voteMapper = sqlSession.getMapper(VoteMapper.class);
        Vote voteInfo = voteMapper.selectByPrimaryKey(voteId);
        if (voteInfo == null) {
            logger.info("获取投票列表失败");
            return null;
        } else {
            logger.info("获取投票列表成功，投票列表：" + voteInfo.toString());
            return voteInfo;
        }
    }

    @Override
    public List<Vote> getMyCreatedVoteList(String wechatId) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        VoteMapper voteMapper = sqlSession.getMapper(VoteMapper.class);
        List<Vote> voteList = voteMapper.selectListByWechatId(wechatId);
        if (voteList.isEmpty()) {
            logger.info("获取我创建的投票列表失败");
            return null;
        } else {
            logger.info("获取我创建的投票列表成功，投票列表为：" + voteList.toString());
            return voteList;
        }
    }
}
