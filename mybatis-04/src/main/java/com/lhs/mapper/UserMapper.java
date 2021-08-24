/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.lhs.mapper;

import com.lhs.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author CoolCucumber
 * @create 2021-08-06-0:05
 */
public interface UserMapper {
    List<User> getUserList();
    User getUserById(int id);

    //map
    User getUserByIdMap(Map<String,Object> map);

    //----增删改需要提交事务
    int addUser(User user);
    //map
    int addUserMap(Map<String,Object> map);

    int updateUser(User user);

    int deleteUser(int id);

    //分页
    List<User> getUserByLimit(Map<String,Integer> map);

    List<User> getUserByRowBounds();
}
