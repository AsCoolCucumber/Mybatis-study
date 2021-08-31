/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.lhs.mapper;

import com.lhs.pojo.Blog;
import com.lhs.utils.IDUtils;
import com.lhs.utils.MybatisUtils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BlogMapperTest {
    @Test
    public void testAddBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setTitle("mybatis is easy");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("java is easy");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("spring is easy");
        mapper.addBlog(blog);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testQueryBlogId(){
        SqlSession sqlSessionAutoCommit = MybatisUtils.getSqlSessionAutoCommit();
        BlogMapper mapper = sqlSessionAutoCommit.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("author", "狂神说");
        map.put("title", "mybatis is easy");
        List<Blog> blogs = mapper.queryBlogIf(map);
        blogs.forEach(System.out::println);
        sqlSessionAutoCommit.close();
    }

    @Test
    public void testQueryBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        // map.put("title", "java is easy");
        // map.put("author", "狂神说");
        map.put("views", 1000);
        List<Blog> blogs = mapper.queryBlogChoose(map);
        blogs.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testUpdateBlog(){
        SqlSession sqlSessionAutoCommit = MybatisUtils.getSqlSessionAutoCommit();
        BlogMapper mapper = sqlSessionAutoCommit.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("title", "java is easy");
        map.put("author", "狂神说");
        map.put("id", "6496e4729ed84b07873d3e0a4b2c4ae0");
        int res = mapper.updateBlog(map);
        if (res > 0){
            System.out.println("get it");
        }
        sqlSessionAutoCommit.close();
    }

    @Test
    public void testQueryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        ArrayList<String> ids = new ArrayList<>();
        ids.add("b5704f7e95204a5ebd5b77410a3a8a55");
        ids.add("6496e4729ed84b07873d3e0a4b2c4ae0");
        List<Blog> blogs = mapper.queryBlogForeach(ids);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void testQueryBlogForeach2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        ArrayList<String> list = new ArrayList<>();
        list.add("b5704f7e95204a5ebd5b77410a3a8a55");
        list.add("6496e4729ed84b07873d3e0a4b2c4ae0");
        map.put("ids", list);
        List<Blog> blogs = mapper.queryBlogForeach2(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

}