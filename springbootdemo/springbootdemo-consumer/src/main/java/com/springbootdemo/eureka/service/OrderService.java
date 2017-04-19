package com.springbootdemo.eureka.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/4/19.
 */

@Service
public class OrderService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * Order Service，func->info
     * @return
     */
    @HystrixCommand(fallbackMethod = "getMoneyServiceFallback")
    public String getMoney() {
        return restTemplate.getForEntity(
                "http://ORDER-SERVICE/info?accessToken=token",
                String.class).getBody();
    }

    String getMoneyServiceFallback() {
        return "error";
    }

    /**
     * Order Service，func->address
     * @return
     */
    @HystrixCommand(fallbackMethod = "getAddressServiceFallback")
    public String getAddress(){
        return restTemplate.getForEntity(
                "http://ORDER-SERVICE/address?accessToken=token",
                String.class).getBody();
    }

    String getAddressServiceFallback() {
        return "error";
    }
}
