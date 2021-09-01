/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.lhs.dao.role;

import static org.junit.Assert.*;

import com.lhs.pojo.Role;
import com.lhs.utils.MybatisUtils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class RoleDaoTest {

    @Test
    public void getRoleList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            RoleDao mapper = sqlSession.getMapper(RoleDao.class);
            List<Role> roleList = mapper.getRoleList();
            for (Role role : roleList) {
                System.out.println(role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}