package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author: shg
 * @create: 2022-05-01 3:23 下午
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashBoard {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoard.class, args);
    }
}
