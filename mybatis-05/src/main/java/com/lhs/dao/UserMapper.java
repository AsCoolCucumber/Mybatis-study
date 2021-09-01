/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.lhs.dao;

import com.lhs.pojo.User;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author CoolCucumber
 * @create 2021-08-06-0:05
 */
public interface UserMapper {
    @Select("select * from t_user")
    List<User> getUserList();

    @Select("select id,name,pwd as password from t_user where id = #{uid}")
    User getUserById(@Param("uid") int id);

    @Insert("insert into t_user values(#{id},#{name},#{password})")
    int addUser(User user);

    @Update("update t_user set name=#{name},pwd=#{password} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from t_user where id = #{id}")
    int deleteUser(int id);
}
