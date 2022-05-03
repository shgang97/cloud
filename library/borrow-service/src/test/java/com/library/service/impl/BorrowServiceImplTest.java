package com.library.service.impl;

import com.library.BorrowApplication;
import com.library.entity.BorrowDetail;
import com.library.service.BorrowService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author: shg
 * @create: 2022-05-03 4:52 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = BorrowApplication.class)
class BorrowServiceImplTest{

    @Autowired
    private BorrowService borrowService;

    @Test
    public void test01() {
        BorrowDetail borrowDetail = borrowService.findBorrowDetailByUid(10);
        System.out.println("borrowDetail = " + borrowDetail);

        List<BorrowDetail> borrowDetailList = borrowService.findBorrowDetailByBid(10);
        System.out.println("borrowDetailList = " + borrowDetailList);

        BorrowDetail borrowDetail1 = borrowService.findBorrowDetailByUidAndBid(10, 2);
        System.out.println("borrowDetail1 = " + borrowDetail1);
    }

}