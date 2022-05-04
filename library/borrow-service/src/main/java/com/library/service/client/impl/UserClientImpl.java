package com.library.service.client.impl;

import com.library.entity.User;
import com.library.service.client.UserClient;
import org.springframework.stereotype.Component;

/**
 * @author: shg
 * @create: 2022-05-03 8:38 下午
 */
@Component
public class UserClientImpl implements UserClient {
    @Override
    public User getUserById(int uid) {
        return new User().setName("图书管理员");
    }

    @Override
    public int findRestById(int id) {
        return 0;
    }

    @Override
    public int borrowOneBook(int id) {
        return 0;
    }
}
