package com.weiyang.vote.mapper;

import com.weiyang.vote.domain.pojo.VoteOption;

import java.util.List;

public interface VoteOptionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VoteOption record);

    int insertSelective(VoteOption record);

    VoteOption selectByPrimaryKey(Integer id);

    List<VoteOption> selectIdsListByVoteId(Integer voteId);

    int updateByPrimaryKeySelective(VoteOption record);

    int updateByPrimaryKey(VoteOption record);

    List<VoteOption> selectListByVoteId(Integer voteId);
}