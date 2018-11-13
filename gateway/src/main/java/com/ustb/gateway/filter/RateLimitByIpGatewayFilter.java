package com.ustb.gateway.filter;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName：RateLimitByIpGatewayFilter
 * Description:采用令牌桶算法实现限流
 * author: mayouwen
 * date: 2018/11/7
 */


@Builder
@Data
@AllArgsConstructor
@Slf4j
public class RateLimitByIpGatewayFilter implements GatewayFilter,Ordered {

    //桶的最大容量（即可放入的token的最大容量）
    private int capacity;

    //每次token补充量
    private int refillTokens;

    //补充token的时间间隔
    private Duration duration;
    //Map 来存储 bucket，所以也决定了它只能单点使用，如果是分布式的话，可以采用 Hazelcast 或 Redis 等解决方案。
    private static final Map<String,Bucket> CACHE = new ConcurrentHashMap<>();

    private Bucket createBucket(){
        Refill refill = Refill.of(refillTokens, duration);
        Bandwidth limit = Bandwidth.classic(capacity, refill);
        return Bucket4j.builder().addLimit(limit).build();
    }
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String ip=exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
        Bucket bucket = CACHE.computeIfAbsent(ip, k -> createBucket());
        log.info("IP:"+ip+",TokenBucket Available Tokens: " + bucket.getAvailableTokens());
        if (bucket.tryConsume(1)){
            return chain.filter(exchange);
        }
        exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
        return exchange.getResponse().setComplete();
    }
    @Override
    public int getOrder() {
        return -10000;
    }
}

