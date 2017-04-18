package com.springbootdemo.eureka;

import com.springbootdemo.eureka.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.audit.listener.AbstractAuditListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class SpringbootdemoEurekaApplication {

	/**
	 * 使过滤器生效
	 * @return
	 */
	@Bean
	public AccessFilter accessFilter(){
		return new AccessFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoEurekaApplication.class, args);
	}
}
