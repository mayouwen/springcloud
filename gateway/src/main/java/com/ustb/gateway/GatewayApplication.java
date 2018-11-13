package com.ustb.gateway;

import com.ustb.gateway.filter.RateLimitByIpGatewayFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.time.Duration;


/**
 * ClassName：GatewayApplication
 * Description:网关服务
 * author: mayouwen
 * date: 2018/11/13
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class);
    }
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes().route(r ->
                r.path("/REGISTERSERVICE/**")
                        .filters(f -> f.stripPrefix(1)
                                .filter(new RateLimitByIpGatewayFilter(10,1,Duration.ofSeconds(1))))
                        .uri("lb://REGISTERSERVICE")
                        .order(0)
                        .id("REGISTERSERVICE"))
                .build();
    }
}
