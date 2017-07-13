package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * http://blog.didispace.com/spring-cloud-starter-dalston-4-1/
 * 注解 @EnableHystrix（等同于@EnableCircuitBreaker） 开启Hystrix的使用
 * 注解 @SpringCloudApplication 中包含SpringBootApplication、EnableDiscoveryClient、EnableCircuitBreaker
 */
@SpringCloudApplication
public class TestEurekaClientRibbonHystrixApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(TestEurekaClientRibbonHystrixApplication.class, args);
	}
}
