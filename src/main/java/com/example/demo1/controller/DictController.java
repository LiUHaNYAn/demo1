package com.example.demo1.controller;

import com.example.demo1.domain.Dict;
import com.example.demo1.service.DictJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CacheConfig(cacheNames = "dict")
public class DictController {
    @Autowired
    private DictJPA dictJPA;
    @Cacheable(cacheNames = "dict.list")
    @RequestMapping("/dict/list")
    public List<Dict> dicts(){
        return dictJPA.findAll();
    }
}
