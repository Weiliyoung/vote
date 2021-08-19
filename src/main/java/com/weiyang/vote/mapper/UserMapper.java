package com.weiyang.vote.mapper;

import com.weiyang.vote.domain.pojo.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    User selectByWechatId(String wechatId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}