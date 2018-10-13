package com.fsocity.security.service;

import org.springframework.stereotype.Service;

/**
 * @author zail
 * @since 2017-12-26
 */
@Service
public class HelloService {
  
  public String greeting(String name) {
    return "hello " + name;
  }
  
}
