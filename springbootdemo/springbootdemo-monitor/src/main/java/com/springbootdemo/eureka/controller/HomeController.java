package com.springbootdemo.eureka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/4/19.
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "forward:/hystrix";
    }
}
