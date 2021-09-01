/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.lhs.dao;

import com.lhs.pojo.Teacher;

import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    // @Select("select * from teacher where id = #{tid}")
    // Teacher getTeacherById(@Param("tid") int id);

    Teacher getTeacher(@Param("tid") int id);

    Teacher getTeacher2(@Param("tid") int id);
}
