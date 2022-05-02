package com.library.controller;

import com.library.entity.BorrowDetail;
import com.library.service.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: shg
 * @create: 2022-04-30 9:30 下午
 */
@RestController
public class BorrowController {

    @Resource
    BorrowService service;

    @RequestMapping("/borrow/{uid}")
    BorrowDetail findBorrowDetails(@PathVariable("uid") int uid){
        return service.getBorrowDetailByUid(uid);
    }
}
