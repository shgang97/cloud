package com.library.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: shg
 * @create: 2022-04-30 10:32 下午
 */
@Configuration
@LoadBalancerClient(value = "user-service", // 指定为 user-service 服务，只要是调用此服务都会使用如下指定都策略
        configuration = LoadBalancerConfig.class) // 指定 LoadBalancerConfig 中配置都负载均衡器
public class BeanConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
