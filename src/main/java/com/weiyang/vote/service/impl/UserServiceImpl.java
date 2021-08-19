package com.weiyang.vote.service.impl;

import com.weiyang.vote.domain.pojo.User;
import com.weiyang.vote.mapper.UserMapper;
import com.weiyang.vote.service.UserService;
import com.weiyang.vote.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Override
    public boolean createUser(User user) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.insert(user);
        logger.info("新增用户信息: " + user.toString());
        logger.info("影响有效结果: " + String.valueOf(result));
        logger.info("新建用户ID: " + String.valueOf(user.getId()));
        sqlSession.commit();
        sqlSession.close();
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User getUserInfo(String wechatId) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User userInfo = userMapper.selectByWechatId(wechatId);
        if (userInfo == null) {
            logger.info("获取团队列表失败");
            return null;
        } else {
            logger.info("获取团队列表成功，团队列表: " + userInfo.toString());
            return userInfo;
        }
    }
}
