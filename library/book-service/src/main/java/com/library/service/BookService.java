package com.library.service;

import com.library.entity.Book;

/**
 * @author: shg
 * @create: 2022-04-30 8:51 下午
 */
public interface BookService {
    Book getBookById(int bid);
}
