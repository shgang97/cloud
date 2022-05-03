package com.library.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author: shg
 * @create: 2022-04-30 8:58 下午
 */
@Data
@ToString
@Accessors(chain = true)
public class Borrow {
    int id;
    int uid;
    int bid;
}
