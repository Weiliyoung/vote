package com.weiyang.vote.mapper;

import com.weiyang.vote.domain.pojo.Vote;

import java.util.List;

public interface VoteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Vote record);

    int insertSelective(Vote record);

    Vote selectByPrimaryKey(Integer id);

    List<Vote> selectListByVoteId(Integer voteId);

    int updateByPrimaryKeySelective(Vote record);

    int updateByPrimaryKeyWithBLOBs(Vote record);

    int updateByPrimaryKey(Vote record);
}