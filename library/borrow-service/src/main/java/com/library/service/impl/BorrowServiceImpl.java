package com.library.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.library.entity.Book;
import com.library.entity.Borrow;
import com.library.entity.BorrowDetail;
import com.library.entity.User;
import com.library.mapper.BorrowMapper;
import com.library.service.BorrowService;
import com.library.service.client.BookClient;
import com.library.service.client.UserClient;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: shg
 * @create: 2022-04-30 9:11 下午
 */
@Service
public class BorrowServiceImpl implements BorrowService {
    @Resource
    private BorrowMapper borrowMapper;

    @Resource
    private UserClient userClient;

    @Resource
    private BookClient bookClient;

    @Override
    @SentinelResource(value = "details",
            blockHandler = "blocked")
    public BorrowDetail findBorrowDetailByUid(int uid) {
        List<Borrow> borrows = borrowMapper.selectBorrowsByUid(uid);
        User user = userClient.getUserById(uid);
        List<Book> bookList = borrows
                .stream()
                .map(borrow -> bookClient.getBookById(borrow.getBid()))
                .collect(Collectors.toList());
        return new BorrowDetail(user, bookList);
    }

    public BorrowDetail blocked(int uid, BlockException e) {
        return new BorrowDetail(null, Collections.emptyList());
    }


    @Override
    public List<BorrowDetail> findBorrowDetailByBid(int bid) {
        List<Borrow> borrows = borrowMapper.selectBorrowsByUid(bid);
        Book book = bookClient.getBookById(bid);
        List<Book> books = new ArrayList<>();
        books.add(book);
        List<BorrowDetail> borrowDetailList = borrows
                .stream()
                .map(borrow -> userClient.getUserById(borrow.getUid()))
                .map(user -> new BorrowDetail(user, books))
                .collect(Collectors.toList());
        return borrowDetailList;
    }

    @Override
    public BorrowDetail findBorrowDetailByUidAndBid(int uid, int bid) {
        Borrow borrow = borrowMapper.selectBorrowByUidAndBid(uid, bid);
        if (borrow == null)
            return null;
        User user = userClient.getUserById(borrow.getUid());
        List<Book> books = new ArrayList<>();
        books.add(bookClient.getBookById(borrow.getBid()));
        return new BorrowDetail(user, books);
    }

    @GlobalTransactional
    @Override
    public boolean doBorrow(int uid, int bid) {
        //1. 判断图书和用户是否都支持借阅
        if(bookClient.getRemain(bid) < 1)
            throw new RuntimeException("图书数量不足");
        if(userClient.findRestById(uid) < 1)
            throw new RuntimeException("用户借阅量不足");
        //2. 首先将图书的数量-1
        if(!bookClient.borrow(bid))
            throw new RuntimeException("在借阅图书时出现错误！");
        //3. 添加借阅信息
        if(borrowMapper.selectBorrowByUidAndBid(uid, bid) != null)
            throw new RuntimeException("此书籍已经被此用户借阅了！");
        if(borrowMapper.addBorrow(uid, bid) <= 0)
            throw new RuntimeException("在录入借阅信息时出现错误！");
        //4. 用户可借阅-1
        if(userClient.borrowOneBook(uid) <= 0)
            throw new RuntimeException("在借阅时出现错误！");
        //完成
        return true;
    }


    /**
     // 使用RestTemplate实现远程调用
     //RestTemplate支持多种方式的远程调用
     @Autowired private RestTemplate restTemplate;

     @Override public BorrowDetail getBorrowDetailByUid(int uid) {
     List<Borrow> borrows = mapper.getBorrowsByUid(uid);
     //那么问题来了，现在拿到借阅关联信息了，怎么调用其他服务获取信息呢？

     //这里通过调用getForObject来请求其他服务，并将结果自动进行封装
     //获取User信息
     User user = restTemplate.getForObject("http://localhost:8101/user/"+uid, User.class);
     //获取每一本书的详细信息
     List<Book> bookList = borrows
     .stream()
     .map(borrow -> restTemplate.getForObject("http://localhost:8201/book/"+borrow.getBid(), Book.class))
     .collect(Collectors.toList());
     return new BorrowDetail(user, bookList);
     }
     */

}
