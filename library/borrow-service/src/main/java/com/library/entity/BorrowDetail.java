package com.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author: shg
 * @create: 2022-04-30 9:01 下午
 */
@Data
@AllArgsConstructor
public class BorrowDetail {
    User user;
    List<Book> bookList;
}
