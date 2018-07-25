package com.example.demo1.controller;

import com.example.demo1.common.Inquirer;
import com.example.demo1.domain.News;
import com.example.demo1.domain.QNews;
import com.example.demo1.service.NewsJPA;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
public class NewsController {
    @Autowired
    private NewsJPA newsJPA;
    @PersistenceContext
    private EntityManager entityManager;
    @RequestMapping("/news/list")
    public List<News> list(){
        QNews news=QNews.news;
        JPAQuery<News> newsJPAQuery=new JPAQuery<News>(entityManager);
        newsJPAQuery.select(news);
        BooleanExpression booleanExpression=news.isnew.eq(true);
        BooleanExpression expression=news.title.contains("ffff");
        newsJPAQuery.select(booleanExpression,expression).select();
        return newsJPAQuery.fetchResults().getResults();
    }
    @RequestMapping("/news/news")
    public  List<News> news(){
        QNews news=QNews.news;
//        JPAQuery<News> newsJPAQuery=new JPAQuery<>(entityManager);
        Inquirer inquirer=new Inquirer();
        BooleanExpression expression=news.title.contains("今天");
        inquirer.putExpression(expression);
        return inquirer.iteratorToList(newsJPA.findAll(inquirer.buildQuery()));
    }
}
