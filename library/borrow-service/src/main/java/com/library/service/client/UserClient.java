package com.library.service.client;

import com.library.entity.User;
import com.library.service.client.impl.UserClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: shg
 * @create: 2022-05-02 4:58 下午
 */
@FeignClient(value = "user-service", fallback = UserClientImpl.class)
public interface UserClient {
    @RequestMapping("/user/{uid}")
    User getUserById(@PathVariable("uid") int uid);
}
