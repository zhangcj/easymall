package com.springbootdemo.eureka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/4/19.
 */

@RestController
public class OrderController {

    private final Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/info" ,method = RequestMethod.GET)
    public String info() {
        ServiceInstance instance = client.getLocalServiceInstance();

        log.info("/info, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return "func->info!";
    }

    @RequestMapping(value = "/address" ,method = RequestMethod.GET)
    public String address() throws Exception {
//        ServiceInstance instance = client.getLocalServiceInstance();
//
//        log.info("/address, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
//        return "func->address!";
        throw new Exception("new err!");
    }
}
