package com.fsocity.sell.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zail
 * @since 2019/12/03
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(EurekaApplication.class, args);
  }
  
}
