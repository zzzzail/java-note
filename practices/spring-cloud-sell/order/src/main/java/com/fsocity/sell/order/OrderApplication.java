package com.fsocity.sell.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zail
 * @since 2019/12/3
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(OrderApplication.class, args);
  }
  
}
