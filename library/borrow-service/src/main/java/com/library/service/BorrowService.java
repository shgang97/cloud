package com.library.service;

import com.library.entity.BorrowDetail;

/**
 * @author: shg
 * @create: 2022-04-30 9:00 下午
 */
public interface BorrowService {
    BorrowDetail getBorrowDetailByUid(int uid);
}
