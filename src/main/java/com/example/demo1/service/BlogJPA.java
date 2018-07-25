package com.example.demo1.service;

import com.example.demo1.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BlogJPA extends JpaRepository<Blog,Long> ,QuerydslPredicateExecutor<Blog>{

}
