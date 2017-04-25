package com.springbootdemo.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/4/25.
 */
@RestController
public class ServiceController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi() {
        return "service01";
    }

    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public String api() {
        return restTemplate.getForEntity(
                "http://localhost:7002/hi",
                String.class).getBody();
    }
}
