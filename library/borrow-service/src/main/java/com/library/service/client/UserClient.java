package com.library.service.client;

import com.library.entity.User;
import com.library.service.client.impl.UserClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: shg
 * @create: 2022-05-01 2:34 下午
 */
@FeignClient(value = "user-service",
        fallback = UserClientImpl.class) // fallback参数指定为我们刚刚编写的实现类
public interface UserClient {
    @RequestMapping("/user/{uid}")
    User findUserById(@PathVariable("uid") int uid);
}
