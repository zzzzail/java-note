package com.fsocity.sell.product.controller;

import com.fsocity.sell.product.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zail
 * @since 2019/12/3
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {
  
  
  @GetMapping("/{id}")
  public Product id(@PathVariable Long id) {
    Product product = new Product();
    product.setId(id);
    product.setName("苹果手机");
    
    log.info("调用商品服务的 product 接口。");
  
    return product;
  }


}
