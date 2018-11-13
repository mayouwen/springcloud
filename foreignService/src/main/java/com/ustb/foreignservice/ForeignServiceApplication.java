package com.ustb.foreignservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * ClassName：ForeignServiceApplication
 * Description:
 * author: mayouwen
 * date: 2018/11/13
 */
@SpringBootApplication
@EnableEurekaClient
public class ForeignServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ForeignServiceApplication.class);
    }
}
