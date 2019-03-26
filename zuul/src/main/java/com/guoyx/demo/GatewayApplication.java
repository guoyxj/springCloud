package com.guoyx.demo;

import com.guoyx.demo.filter.SimpleFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import java.util.Hashtable;

@EnableZuulProxy //开启网关路由
@EnableDiscoveryClient //将此指示为Eureka客户端
@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public SimpleFilter simpleFilter() {

        Hashtable hashtable = new Hashtable();
        return new SimpleFilter();
    }
}
