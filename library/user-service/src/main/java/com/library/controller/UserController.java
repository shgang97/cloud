package com.library.controller;

import com.library.entity.User;
import com.library.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: shg
 * @create: 2022-04-30 8:28 下午
 */
@RestController
public class UserController {

    @Resource
    UserService service;

    //这里以RESTFul风格为例
    @RequestMapping("/user/{uid}")
    public User findUserById(@PathVariable("uid") int uid){
        return service.getUserById(uid);
    }
}
