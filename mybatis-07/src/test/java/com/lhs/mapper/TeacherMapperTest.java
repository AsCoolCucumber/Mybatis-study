/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.lhs.mapper;

import com.lhs.utils.MybatisUtils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TeacherMapperTest {
    @Test
    public void testGetTeacher(){
        SqlSession sqlSessionAutoCommit = MybatisUtils.getSqlSessionAutoCommit();
        TeacherMapper mapper = sqlSessionAutoCommit.getMapper(TeacherMapper.class);
        System.out.println(mapper.getTeacher(1));
    }

    @Test
    public void testGetTeacher2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        System.out.println(mapper.getTeacher2(1));
    }
}