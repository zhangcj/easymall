package com.springbootdemo.eureka.controller;

import com.springbootdemo.eureka.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/4/19.
 */

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/money", method = RequestMethod.GET)
    public String money() {
        return orderService.getMoney();
    }

    @RequestMapping(value = "/address", method = RequestMethod.GET)
    public String address() {
        return orderService.getAddress();
    }
}
