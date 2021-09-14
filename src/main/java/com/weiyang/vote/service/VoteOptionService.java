package com.weiyang.vote.service;


import com.weiyang.vote.domain.pojo.VoteOption;

import java.util.List;

public interface VoteOptionService {
    boolean createVoteOption(VoteOption voteOption);

    List<VoteOption> getVoteOptionIdsList(Integer voteId);

    List<VoteOption> getVoteOptionList(Integer voteId);

    // List<VoteOption> getVoteOptionList(String wechatId);
}
