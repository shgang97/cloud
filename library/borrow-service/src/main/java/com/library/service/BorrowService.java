package com.library.service;

import com.library.entity.Borrow;
import com.library.entity.BorrowDetail;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: shg
 * @create: 2022-04-30 9:00 下午
 */
@Service
public interface BorrowService {

    BorrowDetail findBorrowDetailByUid(int uid);

    List<BorrowDetail> findBorrowDetailByBid(int bid);

    BorrowDetail findBorrowDetailByUidAndBid(int uid, int bid);

    public boolean doBorrow(int uid, int bid);
}
