package com.library.controller;

import com.library.entity.Book;
import com.library.service.BookService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: shg
 * @create: 2022-04-30 8:52 下午
 */
@RestController
public class BookController {

    @Resource
    BookService bookService;

    @RequestMapping("/book/{bid}")
    Book findBookById(@PathVariable("bid") int bid){
        return bookService.findBookById(bid);
    }

    @RequestMapping("/book/remain/{bid}")
    int getRemain(@PathVariable("bid") int bid){
        return bookService.findStockById(bid);
    }

    @RequestMapping("/book/borrow/{bid}")
    boolean borrow(@PathVariable("bid") int bid){
        int stock = bookService.findStockById(bid);
        return bookService.updateRemain(bid, stock - 1);
    }
}
