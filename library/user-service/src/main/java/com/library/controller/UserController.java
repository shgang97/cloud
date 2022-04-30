package com.library.controller;

import com.library.entity.User;
import com.library.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.support.RequestContext;

import javax.annotation.Resource;

/**
 * @author: shg
 * @create: 2022-04-30 8:28 下午
 */
@RestController
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Resource
    UserService service;

    //这里以RESTFul风格为例
    @RequestMapping("/user/{uid}")
    public User findUserById(@PathVariable("uid") int uid){
        LOGGER.info("RequestContextHolder.getRequestAttributes() = %s", RequestContextHolder.getRequestAttributes());
        LOGGER.info("UserController被访问");
        return service.getUserById(uid);
    }
}
