package com.example.demo1.service;

import com.example.demo1.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface UserJPA extends
        JpaRepository<UserInfo,Long> ,
        JpaSpecificationExecutor<UserInfo>,
        Serializable {
}
