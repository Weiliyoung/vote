package com.weiyang.vote.controller;

import com.alibaba.fastjson.JSONObject;
import com.weiyang.vote.domain.pojo.Relationship;
import com.weiyang.vote.domain.pojo.VoteOption;
import com.weiyang.vote.service.RelationshipService;
import com.weiyang.vote.service.VoteOptionService;
import com.weiyang.vote.service.impl.RelationshipServiceImpl;
import com.weiyang.vote.service.impl.VoteOptionServiceImpl;
import com.weiyang.vote.utils.ApiResponseUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.*;
import java.util.List;

@RestController
@RequestMapping("/choice")
public class RelationshipController {

    private static final Logger logger = Logger.getLogger(RelationshipController.class);

    @RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String createChoice(@RequestBody JSONObject requestBody) {
        logger.info("新建接口：新建[createChoice]");
        logger.info("请求内容:" + requestBody);
        Relationship relationship = new Relationship();
        Integer userId = requestBody.getInteger("UserId");
        Integer voteId = requestBody.getInteger("VoteId");
        Integer voteOptionId = requestBody.getInteger("VoteOptionId");
        relationship.setUserId(userId);
        relationship.setVoteId(voteId);
        relationship.setVoteOptionId(voteOptionId);
        relationship.setCreateTime(new Date());
        logger.info(relationship.toString());
        RelationshipService relationshipService = new RelationshipServiceImpl();
        boolean isCreated = relationshipService.createRelationship(relationship);
        if (isCreated) {
            // return "{\"msg\":\"User create successful.\"}";
            return ApiResponseUtils.success(null);
        } else {
            // return "{\"msg\":\"User created fail.\"}";
            return ApiResponseUtils.error(1, "创建失败。");
        }
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getChoicesStats(@RequestParam("VoteId") Integer voteId) {
        logger.info("请求接口：有哪些选项 [getChoiceList]");
        logger.info("查询投票id为：" + voteId);
        List<Map<String, Object>> choicesStatsList = new ArrayList<>();
        VoteOptionService voteOptionService = new VoteOptionServiceImpl();
        RelationshipService relationshipService = new RelationshipServiceImpl();
        List<VoteOption> voteOptionIdsList = voteOptionService.getVoteOptionIdsList(voteId);
        for (VoteOption voteOption : voteOptionIdsList) {
            int voteOptionStats = relationshipService.getChoicesStats(voteId, voteOption.getId());
            Map<String, Object> choicesStatsItem = new HashMap<>();
            choicesStatsItem.put("optionId", voteOption.getId());
            choicesStatsItem.put("choiceStats", voteOptionStats);
            choicesStatsList.add(choicesStatsItem);
        }
        Map<String, Object> choiceStatsMap = new HashMap<>();
        choiceStatsMap.put("voteId", voteId);
        choiceStatsMap.put("choiceStatsList", choicesStatsList);
        return ApiResponseUtils.success(choiceStatsMap);
    }
}
