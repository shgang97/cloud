package com.library.service.client;

import com.library.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: shg
 * @create: 2022-05-02 5:05 下午
 */
@FeignClient("book-service")
public interface BookClient {
    @RequestMapping("/book/{bid}")
    Book getBookById(@PathVariable("bid") int bid);
}
