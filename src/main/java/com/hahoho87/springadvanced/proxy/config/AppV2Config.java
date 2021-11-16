package com.hahoho87.springadvanced.proxy.config;

import com.hahoho87.springadvanced.proxy.app.v2.OrderControllerV2;
import com.hahoho87.springadvanced.proxy.app.v2.OrderRepositoryV2;
import com.hahoho87.springadvanced.proxy.app.v2.OrderServiceV2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppV2Config {
    @Bean
    public OrderControllerV2 orderControllerV2() {
        return new OrderControllerV2(orderServiceV2());
    }

    public OrderServiceV2 orderServiceV2() {
        return new OrderServiceV2(orderRepositoryV2());
    }

    private OrderRepositoryV2 orderRepositoryV2() {
        return new OrderRepositoryV2();
    }
}