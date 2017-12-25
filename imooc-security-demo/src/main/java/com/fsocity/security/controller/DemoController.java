package com.fsocity.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zail
 * @since 2017-12-25
 */
@RestController
public class DemoController {
  
  @GetMapping("/hello")
  public String hello() {
    return "Hello world!";
  }
  
}
