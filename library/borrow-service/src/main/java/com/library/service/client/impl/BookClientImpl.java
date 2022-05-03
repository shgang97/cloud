package com.library.service.client.impl;

import com.library.entity.Book;
import com.library.service.client.BookClient;
import org.springframework.stereotype.Component;

/**
 * @author: shg
 * @create: 2022-05-03 8:35 下午
 */
@Component
public class BookClientImpl implements BookClient {
    @Override
    public Book getBookById(int bid) {
        return new Book().setDesc("替代方案");
    }
}
