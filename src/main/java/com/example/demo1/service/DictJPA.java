package com.example.demo1.service;


import com.example.demo1.domain.Dict;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public interface DictJPA extends JpaRepository<Dict,String> {

}
