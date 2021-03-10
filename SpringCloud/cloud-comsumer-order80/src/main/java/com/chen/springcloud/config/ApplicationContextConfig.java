package com.chen.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * @author chen
 * @date 2021/2/27 18:59
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced//使用LoadBalanced注解赋予RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
