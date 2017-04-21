package com.zcj.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/4/6.
 */

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", produces = "application/json;charset=UTF-8")
    public String index() {
        return "Hello Docker World."
                + "<br />Welcome to <a href='https://my.oschina.net/u/1000241/blog'>waylau.com</a></li>";
    }
}
