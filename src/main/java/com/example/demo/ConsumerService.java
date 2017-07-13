package com.example.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 此时我们将获得的返回结果为：fallback
 * 我们从eureka-client的控制台中，可以看到服务提供方输出了原本要返回的结果
 * 但是由于返回前延迟了5秒，而服务消费方触发了服务请求超时异常
 * 服务消费者就通过HystrixCommand注解中指定的降级逻辑进行执行，因此该请求的结果返回了fallback。
 */
@Service
public class ConsumerService {

  private RestTemplate restTemplate;

  /**
   * 原档注释 @HystrixCommand(fallbackMethod = "getByIdFallback")
   *      public String getById(String id) {...}
   *      private String getByIdFallback(String id) {...}
   *
   * 调用远程方法，假设调用段超时 那么调用fallbackMethod里指定的方法
   */
  @HystrixCommand(fallbackMethod = "fallback")
  String consumre(){
    return restTemplate.getForObject("http://test-eureka-client/dc",String.class);
  }

  /**
   * 当用户请求超时之后替代需要调用的方法
   */
  private String fallback(){
    return "fallback";
  }

  @Autowired
  public ConsumerService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }
}
