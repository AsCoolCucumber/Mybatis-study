/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.lhs.mapper;

import static org.junit.Assert.*;

import com.lhs.pojo.Student;
import com.lhs.utils.MybatisUtils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentMapperTest {
    @Test
    public void testGetStudent(){
        SqlSession sqlSessionAutoCommit = MybatisUtils.getSqlSessionAutoCommit();
        StudentMapper mapper = sqlSessionAutoCommit.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent();
        studentList.forEach(System.out::println);
        sqlSessionAutoCommit.close();
    }

    @Test
    public void testGetStudent2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent2();
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}