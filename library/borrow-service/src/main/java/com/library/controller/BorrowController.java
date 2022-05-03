package com.library.controller;

import com.library.entity.BorrowDetail;
import com.library.service.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: shg
 * @create: 2022-04-30 9:30 下午
 */
@RestController
public class BorrowController {

    @Resource
    BorrowService borrowService;

    @RequestMapping("/borrow/user/{uid}")
    BorrowDetail getBorrowDetailByUid(@PathVariable("uid") int uid){
        return borrowService.findBorrowDetailByUid(uid);
    }

    @RequestMapping("/borrow/book/{bid}")
    List<BorrowDetail> findBorrowDetailsByBid(@PathVariable("bid") int bid){
        return borrowService.findBorrowDetailByBid(bid);
    }

    @RequestMapping("/borrow/{uid}/{bid}")
    BorrowDetail findBorrowDetail(@PathVariable("uid") int uid,
                                  @PathVariable("bid") int bid){
        return borrowService.findBorrowDetailByUidAndBid(uid, bid);
    }
}
