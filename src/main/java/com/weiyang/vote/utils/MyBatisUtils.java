package com.weiyang.vote.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class MyBatisUtils {
    // MyBatis工具类

    private static SqlSessionFactory sqlSessionFactory; //创建 SqlSessionFactory 对象
    private static final Class CLASS_LOCK = MyBatisUtils.class; // 定义类锁

    /**
     * 私有化构造
     */
    private MyBatisUtils() {
    }

    /**
     * 创建单例对象
     *
     * @return sqlSessionFactory SqlSessionFactory的单例对象
     */
    public static SqlSessionFactory initSqlSessionFactory() {

        // 创建sqlSessionFactory
        String resource = "MapperConfig.xml"; // MyBatis配置文件
        InputStream inputStream = null; // 初始化配置文件流

        try {
            inputStream = Resources.getResourceAsStream(resource);  // 读取配置文件流
        } catch (IOException e) {
            e.printStackTrace();
        }

        synchronized (CLASS_LOCK) {
            // 对类加锁， 防止多线程环境造成对象不唯一
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); // 根据配置文件生成 sqlSessionFactory
            }
        }
        return sqlSessionFactory;
    }

    /**
     * 获取SqlSession
     *
     * @return sqlSession 操作数据库接口
     */
    public static SqlSession getSqlSession() {
        if (sqlSessionFactory == null) {    // 保证通过单例来管理全局唯一的 sqlSessionFactory
            initSqlSessionFactory();
        }
        return sqlSessionFactory.openSession(); // 创建 sqlSession
    }

    public static void main(String[] args) {
        // 调试代码
        // SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // User user = new User();
        // user.setId(0);
        // user.setName("will");
        // user.setPhone("13750012345");
        // user.setWechatId("willyeec");
        // user.setCreateTime(new Date());
        // int result = userMapper.insert(user);
        // System.out.println(result);
        // System.out.println(user.getId());
        // sqlSession.commit();
        //
        // User userItem = userMapper.selectByPrimaryKey(1);
        // System.out.println(userItem.toString());
        //
        // sqlSession.close();

        // ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
        // List<Project> projectList = projectMapper.selectByOwner("weiyuchen");
        // System.out.println(projectList.get(0).getName());
    }

}