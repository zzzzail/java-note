package com.fsocity.sell.order.controller;

import com.fsocity.sell.order.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zail
 * @since 2019/12/3
 */
@RestController
@RequestMapping("/product2")
public class Product2Controller {
  
  @Autowired
  private ProductClient productClient;
  
  @GetMapping("/{id}")
  public String id(@PathVariable Long id) {
    return productClient.id(id);
  }
  
  
}
