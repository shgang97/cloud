package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: shg
 * @create: 2022-04-30 6:43 下午
 */
@SpringBootApplication
@EnableFeignClients
public class BorrowApplication {
    public static void main(String[] args) {
        SpringApplication.run(BorrowApplication.class, args);
    }

//    @Bean
//    RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
}
