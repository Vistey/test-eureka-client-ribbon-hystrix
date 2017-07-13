package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 调用consumerService中的降级方法
 */
@RestController
public class DcController {

  private final ConsumerService consumerService;

  @GetMapping("/consumer")
  public String dc(){
    return consumerService.consumre();
  }

  @Autowired
  public DcController(ConsumerService consumerService) {
    this.consumerService = consumerService;
  }
}
