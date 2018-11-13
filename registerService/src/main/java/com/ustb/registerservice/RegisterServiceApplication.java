package com.ustb.registerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName：RegisterServiceApplication
 * Description:
 * author: mayouwen
 * date: 2018/11/13
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix //开启断路器和 @HystrixCommand 组合使用
public class RegisterServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegisterServiceApplication.class);
    }
}
