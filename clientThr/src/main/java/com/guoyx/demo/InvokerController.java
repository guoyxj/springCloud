package com.guoyx.demo;

import com.guoyx.demo.service.ReqService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class InvokerController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ReqService reqService;

    @RequestMapping("/hi")
    public String hi(@RequestParam(value="name", defaultValue="Artaban") String name) {
        //String greeting = restTemplate.getForObject("http://say-hello/greeting", String.class);
        String greeting = reqService.getHi();
        return String.format("%s, %s!", greeting, name);
    }

}
