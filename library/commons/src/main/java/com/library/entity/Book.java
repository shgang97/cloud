package com.library.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author: shg
 * @create: 2022-04-30 8:50 下午
 */
@Data
@ToString
@Accessors(chain = true)
public class Book {
    int bid;
    String title;
    String desc;
}
