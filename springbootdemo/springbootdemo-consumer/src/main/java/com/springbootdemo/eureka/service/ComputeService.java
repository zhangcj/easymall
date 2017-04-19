package com.springbootdemo.eureka.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/4/18.
 */
@Service
public class ComputeService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String add() {
//        return restTemplate.getForEntity(
//                "http://COMPUTE-SERVICE/add?a=1&b=2&accessToken=token",
//                String.class).getBody();

        return restTemplate.getForEntity(
                "http://API-GATEWAY/api-compute/add?a=1&b=2&accessToken=token",
                String.class).getBody();
    }

    String addServiceFallback() {
        return "error";
    }
}
