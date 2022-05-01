package com.library.controller;

import com.library.entity.BorrowDetail;
import com.library.service.BorrowService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * @author: shg
 * @create: 2022-04-30 9:30 下午
 */
@RestController
public class BorrowController {


    @Resource
    BorrowService service;

    @HystrixCommand//(fallbackMethod = "onError") //使用@HystrixCommand来指定备选方案
    @RequestMapping("/borrow/{uid}")
    BorrowDetail findBorrowDetails(@PathVariable("uid") int uid){
        return service.getBorrowDetailByUid(uid);
    }

    //备选方案，这里直接返回空列表了
    //注意参数和返回值要和上面的一致
//    BorrowDetail onError(int uid){
//        return new BorrowDetail(null, Collections.emptyList());
//    }
}
