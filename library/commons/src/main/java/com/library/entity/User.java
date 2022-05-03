package com.library.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author: shg
 * @create: 2022-04-30 7:28 下午
 */
@Data
@ToString
@Accessors(chain = true)
public class User {
    int uid;
    String name;
    String sex;
}
