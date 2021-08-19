package com.weiyang.vote.service;

import com.weiyang.vote.domain.pojo.Vote;

public interface VoteService {
    boolean createVote(Vote vote);

    Vote getVoteInfo(Integer voteId);
}
