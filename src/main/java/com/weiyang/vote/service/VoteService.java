package com.weiyang.vote.service;

import com.weiyang.vote.domain.pojo.Vote;

import java.util.List;

public interface VoteService {
    boolean createVote(Vote vote);

    Vote getVoteInfo(Integer voteId);

    List<Vote> getMyCreatedVoteList(String wechatId);
}
