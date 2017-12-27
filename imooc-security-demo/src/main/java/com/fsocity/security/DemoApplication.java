package com.fsocity.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zail
 * @since 2017-12-25
 */
@SpringBootApplication
@EnableSwagger2
public class DemoApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class);
  }
  
}
