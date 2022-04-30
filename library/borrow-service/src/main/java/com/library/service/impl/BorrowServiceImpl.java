package com.library.service.impl;

import com.library.entity.Book;
import com.library.entity.Borrow;
import com.library.entity.BorrowDetail;
import com.library.entity.User;
import com.library.mapper.BorrowMapper;
import com.library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: shg
 * @create: 2022-04-30 9:11 下午
 */
@Service
public class BorrowServiceImpl implements BorrowService {
    @Resource
    BorrowMapper mapper;

    //RestTemplate支持多种方式的远程调用
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public BorrowDetail getBorrowDetailByUid(int uid) {
        List<Borrow> borrows = mapper.getBorrowsByUid(uid);
        //那么问题来了，现在拿到借阅关联信息了，怎么调用其他服务获取信息呢？

        //这里通过调用getForObject来请求其他服务，并将结果自动进行封装
        //获取User信息
        User user = restTemplate.getForObject("http://user-service/user/"+uid, User.class);
        //获取每一本书的详细信息
        List<Book> bookList = borrows
                .stream()
                .map(borrow -> restTemplate.getForObject("http://book-service/book/"+borrow.getBid(), Book.class))
                .collect(Collectors.toList());
        return new BorrowDetail(user, bookList);
    }
}
