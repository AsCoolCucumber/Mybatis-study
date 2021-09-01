/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.lhs.dao.bill;

import com.lhs.utils.MybatisUtils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class BillDaoTest {

    @Test
    public void add() {
    }

    @Test
    public void getBillList() {
    }

    @Test
    public void deleteBillById() {
    }

    @Test
    public void getBillById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            BillDao mapper = sqlSession.getMapper(BillDao.class);
            System.out.println(mapper.getBillById(18));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void modify() {
    }

    @Test
    public void getBillCountByProviderId() {
    }
}