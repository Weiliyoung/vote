package com.weiyang.vote.controller;

import com.alibaba.fastjson.JSONObject;
import com.weiyang.vote.domain.pojo.VoteOption;
import com.weiyang.vote.service.VoteOptionService;
import com.weiyang.vote.service.impl.VoteOptionServiceImpl;
import com.weiyang.vote.utils.ApiResponseUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/option")
public class OptionController {
    private static final Logger logger = Logger.getLogger(OptionController.class);

    @RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String createVoteOption(@RequestBody JSONObject requestBody) {
        logger.info("请求接口：新建选项 [createOption]");
        logger.info("请求内容: " + requestBody);
        VoteOption voteOption = new VoteOption();
        Integer voteId = requestBody.getInteger("VoteId");
        String content = requestBody.getString("Content");
        String pictureUrl = requestBody.getString("PictureUrl");
        voteOption.setId(0);
        voteOption.setVoteId(voteId);
        voteOption.setOptionContent(content);
        voteOption.setPictureUrl(pictureUrl);
        VoteOptionService voteOptionService = new VoteOptionServiceImpl();
        boolean isCreated = voteOptionService.createVoteOption(voteOption);
        if (isCreated) {
            // return "{\"msg\":\"User create successful.\"}";
            return ApiResponseUtils.success(null);
        } else {
            // return "{\"msg\":\"User created fail.\"}";
            return ApiResponseUtils.error(1, "创建失败。");
        }
    }
}
