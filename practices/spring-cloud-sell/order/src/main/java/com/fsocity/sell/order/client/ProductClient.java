package com.fsocity.sell.order.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zail
 * @since 2019/12/3
 */
@FeignClient(name = "product")
public interface ProductClient {
  
  @GetMapping("/product/{id}")
  String id(Long id);
  
}
