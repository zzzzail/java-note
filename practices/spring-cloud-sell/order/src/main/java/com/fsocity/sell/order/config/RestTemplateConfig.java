package com.fsocity.sell.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zail
 * @since 2019/12/3
 */
@Configuration
public class RestTemplateConfig {
  
  /**
   * 使用 @LoadBalanced 注解， 可以在 RestTemplate 中直接使用应用名称调用。
   *
   * @return
   */
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
  
}
