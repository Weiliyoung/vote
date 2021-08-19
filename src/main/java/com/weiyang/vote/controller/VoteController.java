package com.weiyang.vote.controller;

import com.alibaba.fastjson.JSONObject;
import com.weiyang.vote.domain.pojo.Vote;
import com.weiyang.vote.domain.pojo.VoteOption;
import com.weiyang.vote.domain.vo.VoteResponse;
import com.weiyang.vote.service.VoteOptionService;
import com.weiyang.vote.service.VoteService;
import com.weiyang.vote.service.impl.VoteOptionServiceImpl;
import com.weiyang.vote.service.impl.VoteServiceImpl;
import com.weiyang.vote.utils.ApiResponseUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/vote")
public class VoteController {

    private static final Logger logger = Logger.getLogger(VoteController.class);

    @RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String createVote(@RequestBody JSONObject requestBody) {
        logger.info("请求接口: 新建投票 [createVote]");
        logger.info("请求内容: " + requestBody);
        Vote vote = new Vote();
        Integer wechatid = requestBody.getInteger("WechatId");
        String title = requestBody.getString("Title");
        String description = requestBody.getString("Description");
        Integer type = requestBody.getInteger("Type");
        String picUrl = null;
        if (type == 1) {
            boolean isPicUrlExisted = requestBody.containsKey("PicUrl");
            System.out.println(isPicUrlExisted);
            if (!isPicUrlExisted) {
                return ApiResponseUtils.error(1, "缺少参数picUrl(图片地址)");
            } else {
                picUrl = requestBody.getString("PicUrl");
                if ("".equals(picUrl)) {
                    return ApiResponseUtils.error(1, "picUrl不能为空");
                }
            }
        }
        String cutOffTime = requestBody.getString("CutOffTime");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date cutOffDateTime = null;
        try {
            cutOffDateTime = simpleDateFormat.parse(cutOffTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        vote.setId(0);
        vote.setWechatId(Integer.toString(wechatid));
        vote.setTitle(title);
        vote.setDescription(description);
        vote.setType(type);
        vote.setStatus(0);
        vote.setPicUrl(picUrl);
        vote.setCutOffTime(cutOffDateTime);
        vote.setCreateTime(new Date());
        logger.info(vote.toString());
        VoteService voteService = new VoteServiceImpl();
        boolean isCreated = voteService.createVote(vote);
        if (isCreated) {
            return ApiResponseUtils.success(null);
        } else {
            return ApiResponseUtils.error(1, "投票创建失败。");
        }

    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getVoteInfo(@RequestParam("voteId") Integer voteId) {
        logger.info("请求接口：用户创建投票ID [getVoteList]");
        VoteService voteService = new VoteServiceImpl();
        System.out.println(voteId);
        Vote voteInfo = voteService.getVoteInfo(voteId);
        String response = "";
        if (voteInfo == null) {
            response = ApiResponseUtils.error(1, "获取创建投票ID失败");
            logger.info("获取失败，请求返回内容为：" + response);
        } else {
            VoteOptionService voteOptionService = new VoteOptionServiceImpl();
            List<VoteOption> voteOptionList = voteOptionService.getVoteOptionList(voteId);
            logger.info("选项列表为：" + voteOptionList.toString());
            List<Map<String, String>> voteOptionsList = new ArrayList<>();
            for (VoteOption voteOption : voteOptionList) {
                Map<String, String> voteOptionMap = new HashMap<>();
                voteOptionMap.put("id", voteOption.getId().toString());
                voteOptionMap.put("optionContent", voteOption.getOptionContent());
                voteOptionMap.put("pictureUrl", voteOption.getPictureUrl());
                voteOptionsList.add(voteOptionMap);
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            VoteResponse voteResponse = new VoteResponse(voteInfo.getId(), voteInfo.getWechatId(), voteInfo.getTitle(), voteInfo.getDescription(), voteInfo.getType(), voteInfo.getStatus(), simpleDateFormat.format(voteInfo.getCreateTime()), simpleDateFormat.format(voteInfo.getCutOffTime()), null, null, voteOptionsList);
            response = ApiResponseUtils.success(voteResponse);
            logger.info("获取成功，请求返回内容为：" + response);
        }
        return response;
    }
}


