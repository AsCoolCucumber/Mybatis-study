/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.lhs.mapper;

import com.lhs.pojo.User;
import com.lhs.utils.MybatisUtils;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CoolCucumber
 * @create 2021-08-06-0:10
 */
public class UserMapperTest {
    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void testGetUserList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e){
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testLogger(){
        logger.info("this is the info logger");
        logger.debug("this is the debug logger");
        logger.error("this is the error logger");
    }

    @Test
    public void testGetUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex", 1);
        map.put("pageSize", 2);
        List<User> userList = mapper.getUserByLimit(map);
        userList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testGetUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RowBounds rowBounds = new RowBounds(0, 2);
        List<User> list = sqlSession.selectList("com.lhs.mapper.UserMapper.getUserByRowBounds", null, rowBounds);
        for (User user : list) {
            System.out.println(user);
        }
    }
}
