package com.library.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.library.entity.User;
import com.library.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: shg
 * @create: 2022-04-30 8:28 下午
 */
@RestController
public class UserController {
    @Resource
    UserService userService;

    //这里以RESTFul风格为例
    @SentinelResource(value = "user")
    @RequestMapping(value = "/user/{uid}", method = RequestMethod.GET)
    public User findUserById(@PathVariable("uid") int uid) {
        return userService.getUserById(uid);
    }

    @RequestMapping(value = "/user/remain/{id}", method = RequestMethod.GET)
    public int findRestById(@PathVariable("id") int id) {
        return userService.getRestById(id);
    }

    @RequestMapping(value = "/user/borrow/{id}", method = RequestMethod.GET)
    public int borrowOneBook(@PathVariable("id") int id) {
        int rest = userService.getRestById(id);
        return userService.updateRestById(id, rest - 1);
    }
}
