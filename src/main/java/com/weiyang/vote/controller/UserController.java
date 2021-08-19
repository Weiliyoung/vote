package com.weiyang.vote.controller;

import com.alibaba.fastjson.JSONObject;

import com.weiyang.vote.domain.pojo.User;
import com.weiyang.vote.service.UserService;
import com.weiyang.vote.service.impl.UserServiceImpl;
import com.weiyang.vote.utils.ApiResponseUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String createUser(@RequestBody JSONObject requestBody) {
        logger.info("请求接口: 新建用户 [createUser]");
        logger.info("请求内容: " + requestBody);
        User user = new User();
        String name = requestBody.getString("WxName");
        String wxId = requestBody.getString("WxId");
        String phone = requestBody.getString("Phone");
        user.setId(0);
        user.setName(name);
        user.setWechatId(wxId);
        user.setPhone(phone);
        user.setCreateTime(new Date());
        UserService userService = new UserServiceImpl();
        boolean isCreated = userService.createUser(user);
        if (isCreated) {
            return ApiResponseUtils.success(null);
        } else {
            return ApiResponseUtils.error(1, "用户创建失败。");
        }

    }

    /**
     * 获取mysql中的数据
     * 查看是否有该用户
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getUserInfo(@RequestParam("wechatId") String wechatId) {
        logger.info("请求接口: 获取用户列表 [getUserList]");
        UserService userService = new UserServiceImpl();
        User userInfo = userService.getUserInfo(wechatId);
        String response = "";
        if (userInfo == null) {
            response = ApiResponseUtils.error(1, "获取用户信息失败。");
            logger.info("获取用户信息失败, 请求返回内容为：" + response);
        } else {
            response = ApiResponseUtils.success(userInfo);
            logger.info("获取用户信息成功, 请求返回内容为：" + response);
        }
        return response;
    }
}
