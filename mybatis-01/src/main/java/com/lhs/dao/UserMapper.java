package com.lhs.dao;

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
}
