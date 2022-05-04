package com.library.service.impl;

import com.library.entity.User;
import com.library.mapper.UserMapper;
import com.library.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: shg
 * @create: 2022-04-30 8:27 下午
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public User getUserById(int uid) {
        return userMapper.getUserById(uid);
    }

    @Override
    public int getRestById(int id) {
        return userMapper.selectRestById(id);
    }

    @Override
    public int updateRestById(int id, int rest) {
        return userMapper.updateRestById(id, rest);
    }
}
