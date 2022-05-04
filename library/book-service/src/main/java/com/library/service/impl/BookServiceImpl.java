package com.library.service.impl;

import com.library.entity.Book;
import com.library.mapper.BookMapper;
import com.library.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: shg
 * @create: 2022-04-30 8:52 下午
 */
@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookMapper bookMapper;

    @Override
    public Book findBookById(int bid) {
        return bookMapper.getBookById(bid);
    }

    @Override
    public boolean updateRemain(int bid, int stock) {
        return bookMapper.updateStockById(bid, stock) > 0;
    }

    @Override
    public int findStockById(int bid) {
        return bookMapper.selectStockById(bid);
    }
}
