/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.lhs.dao.user;

import com.lhs.pojo.User;
import com.lhs.utils.MybatisUtils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class UserDaoTest {

    @Test
    public void add() {
        SqlSession sqlSessionAutoCommit = MybatisUtils.getSqlSessionAutoCommit();
        try {
            UserDao mapper = sqlSessionAutoCommit.getMapper(UserDao.class);
            int res = mapper.add(
                new User(null, "test", "test", "000000", 1, new Date(), "12345678901", "china", 3, 1, new Date(), null,
                    null, null, null));
            if (res > 0) {
                System.out.println(mapper.getLoginUser("test"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getLoginUser() {
        SqlSession sqlSessionAutoCommit = MybatisUtils.getSqlSessionAutoCommit();
        try {
            UserDao mapper = sqlSessionAutoCommit.getMapper(UserDao.class);
            User user = mapper.getLoginUser("admin");
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getUserList() {
        SqlSession sqlSessionAutoCommit = MybatisUtils.getSqlSessionAutoCommit();
        try {
            UserDao mapper = sqlSessionAutoCommit.getMapper(UserDao.class);
            HashMap map = new HashMap();
            map.put("userName", "test");
            map.put("userRole", 3);
            map.put("currentPageNo", (1 - 1) * 10);
            map.put("pageSize", 10);
            List<User> userList = mapper.getUserList(map);
            userList.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getUserCount() {
        SqlSession sqlSessionAutoCommit = MybatisUtils.getSqlSessionAutoCommit();
        try {
            UserDao mapper = sqlSessionAutoCommit.getMapper(UserDao.class);
            HashMap map = new HashMap();
            map.put("userName", "test");
            map.put("userRole", 3);
            int count = mapper.getUserCount(map);
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteUserById() {
        SqlSession sqlSessionAutoCommit = MybatisUtils.getSqlSessionAutoCommit();
        try {
            UserDao mapper = sqlSessionAutoCommit.getMapper(UserDao.class);
            int res = mapper.deleteUserById(14);
            if (res > 0){
                System.out.println("success!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getUserById() {
        SqlSession sqlSessionAutoCommit = MybatisUtils.getSqlSessionAutoCommit();
        try {
            UserDao mapper = sqlSessionAutoCommit.getMapper(UserDao.class);
            User user = mapper.getUserById(16);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void modify() {
        SqlSession sqlSessionAutoCommit = MybatisUtils.getSqlSessionAutoCommit();
        try {
            UserDao mapper = sqlSessionAutoCommit.getMapper(UserDao.class);
            HashMap map = new HashMap();
            map.put("id", 15);
            map.put("userName", "test");
            map.put("phone", "12345678901");
            map.put("modifyBy",1);
            map.put("modifyDate", new Date());
            int res = mapper.modify(map);
            if (res > 0){
                System.out.println(mapper.getUserById(15));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updatePwd() {
        SqlSession sqlSessionAutoCommit = MybatisUtils.getSqlSessionAutoCommit();
        try {
            UserDao mapper = sqlSessionAutoCommit.getMapper(UserDao.class);
            HashMap map = new HashMap();
            map.put("id", 16);
            map.put("userPassword", "666666");
            int res = mapper.updatePwd(map);
            if (res > 0){
                System.out.println(mapper.getUserById(16));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}