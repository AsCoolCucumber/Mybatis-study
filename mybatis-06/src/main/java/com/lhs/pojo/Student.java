/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.lhs.pojo;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;

    //每个学生需要关联一个老师
    private Teacher teacher;
}
