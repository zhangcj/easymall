package com.springbootdemo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringbootdemoEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoEurekaClientApplication.class, args);
	}
}
