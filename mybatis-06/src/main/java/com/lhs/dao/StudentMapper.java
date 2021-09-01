/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.lhs.dao;

import com.lhs.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> getStudent();

    List<Student> getStudent2();
}
