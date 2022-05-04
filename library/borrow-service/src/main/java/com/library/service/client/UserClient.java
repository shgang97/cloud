package com.library.service.client;

import com.library.entity.User;
import com.library.service.client.impl.UserClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: shg
 * @create: 2022-05-02 4:58 下午
 */
@FeignClient(value = "user-service", fallback = UserClientImpl.class)
public interface UserClient {
    @RequestMapping("/user/{uid}")
    User getUserById(@PathVariable("uid") int uid);

    @RequestMapping(value = "/user/remain/{id}", method = RequestMethod.GET)
    int findRestById(@PathVariable("id") int id);

    @RequestMapping(value = "/user/borrow/{id}", method = RequestMethod.GET)
    int borrowOneBook(@PathVariable("id") int id);
}
