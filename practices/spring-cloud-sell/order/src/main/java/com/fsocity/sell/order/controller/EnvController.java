package com.fsocity.sell.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zail
 * @since 2019/12/4
 */
@RestController
@RequestMapping("/env")
public class EnvController {
  
  @Value("${env}")
  public String env;
  
  @GetMapping("/print")
  public String print() {
    return env;
  }

}
