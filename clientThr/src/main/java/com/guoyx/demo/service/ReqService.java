package com.guoyx.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ReqService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "reliable")
    public String getHi(){
        try {
            return this.restTemplate.getForObject("http://say-hello/greeting", String.class);
        } catch (RestClientException e) {
            System.out.println("请求发生错误");
            e.printStackTrace();
            return "ERROR";
        }
    }

    public String reliable(){
        return "Server is down";
    }
}
