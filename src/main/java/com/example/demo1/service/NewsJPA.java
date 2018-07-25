package com.example.demo1.service;

import com.example.demo1.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface NewsJPA extends
        JpaRepository<News,Long>,
        QuerydslPredicateExecutor<News>{

}
