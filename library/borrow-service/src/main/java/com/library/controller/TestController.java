package com.library.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: shg
 * @create: 2022-05-02 11:25 下午
 */
@RestController
@RefreshScope
public class TestController {

//    @Value("${test.txt}")
//    private String txt;
//
//    @RequestMapping(path = "/test", method = RequestMethod.GET)
//    public void test() {
//        System.out.println("txt = " + txt);
//    }
}
