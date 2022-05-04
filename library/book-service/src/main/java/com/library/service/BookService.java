package com.library.service;

import com.library.entity.Book;

/**
 * @author: shg
 * @create: 2022-04-30 8:51 下午
 */
public interface BookService {
    Book findBookById(int bid);

    boolean updateRemain(int bid, int stock);

    int findStockById(int bid);
}
