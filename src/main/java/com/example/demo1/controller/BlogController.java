package com.example.demo1.controller;

import com.example.demo1.domain.Blog;
import com.example.demo1.domain.QBlog;
import com.example.demo1.service.UserJPA;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private UserJPA userJPA;
    @PersistenceContext
    private EntityManager entityManager;
    @RequestMapping("/blog/list")
    public List<Blog> list(){
        QBlog blog=QBlog.blog;
        JPAQuery<Blog> blogJPAQuery=new JPAQuery<>(entityManager);
        QueryResults<Blog> blogs=blogJPAQuery.select(blog).from(blog)
                .where(blog.content.contains("fff"))
                .fetchResults();
        return  blogs.getResults();
    }

}
