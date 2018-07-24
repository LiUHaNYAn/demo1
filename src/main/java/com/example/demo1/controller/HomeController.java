package com.example.demo1.controller;

import com.example.demo1.domain.UserInfo;
import com.example.demo1.service.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class HomeController {
    @Autowired
    private UserJPA userJPA;

    @RequestMapping("/")
    public ModelAndView Index(){
        return new ModelAndView("/home/index");
    }

    @RequestMapping("/list")
    public List<UserInfo> Hello(){
        return userJPA.findAll();
    }
    @RequestMapping(value = "/user/add",method = RequestMethod.POST)
    public  UserInfo Add(UserInfo model){
        return userJPA.save(model);
    }
    @RequestMapping(value = "/user/update",method = RequestMethod.POST)
    public  UserInfo Edit(UserInfo model){
        return  userJPA.save(model);
    }
    @RequestMapping(value = "/user/delete",method = RequestMethod.GET)
    public String Delete(Long userid){
        Optional<UserInfo> user=userJPA.findById(userid);
        if(user.get()==null){
            return "no user";
        }
        userJPA.delete(user.get());
        return  "success";
    }
}

