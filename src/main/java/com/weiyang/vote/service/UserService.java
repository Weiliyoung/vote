package com.weiyang.vote.service;

import com.weiyang.vote.domain.pojo.User;

public interface UserService {
    boolean createUser(User user);

    User getUserInfo(String wechatId);
}
