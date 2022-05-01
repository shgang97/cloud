package com.library.service.client.impl;

import com.library.entity.User;
import com.library.service.client.UserClient;
import org.springframework.stereotype.Component;

/**
 * @author: shg
 * @create: 2022-05-01 3:09 下午
 */
@Component
public class UserClientImpl implements UserClient {
    @Override
    public User findUserById(int uid) { //这里我们自行对其进行实现，并返回我们的替代方案
        return new User();
    }
}
