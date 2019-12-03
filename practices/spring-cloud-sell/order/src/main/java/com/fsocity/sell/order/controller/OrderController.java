package com.fsocity.sell.order.controller;

import com.fsocity.sell.order.entity.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zail
 * @since 2019/12/3
 */
@RestController
@RequestMapping("/order")
public class OrderController {
  
  
  @GetMapping("/{id}")
  public Order id(@PathVariable Long id) {
    Order order = new Order();
    order.setId(id);
    order.setOrderNo("0109101920");
    order.setOrderProductName("月老");
    
    return order;
  }
  
  
}
