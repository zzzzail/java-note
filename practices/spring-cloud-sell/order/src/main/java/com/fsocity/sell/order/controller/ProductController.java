package com.fsocity.sell.order.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zail
 * @since 2019/12/3
 */
@RestController
@RequestMapping("/product")
public class ProductController {
  
  @Autowired
  private LoadBalancerClient loadBalancerClient;
  @Autowired
  private RestTemplate restTemplate;
  
  @GetMapping("/{id}")
  public String getProduct(@PathVariable Long id) {
    // 第一种方式： 使用 RestTemplate 请求（把 url 写死）
    // RestTemplate restTemplate = new RestTemplate();
    // String result = restTemplate.getForObject("http://127.0.0.1:8082/product/" + id, String.class);
    
    // 第二种方式： LoadBalancerClient 根据应用名称获取 url，再使用 RestTemplate 请求 url
    ServiceInstance serviceInstance = loadBalancerClient.choose("product");
    String url = String.format("http://%s:%s/product/%d", serviceInstance.getHost(), serviceInstance.getPort(), id);
    RestTemplate restTemplate = new RestTemplate();
    String result = restTemplate.getForObject(url, String.class);
    
    // 第三种方式：
    // String result = restTemplate.getForObject("http://product/product/" + id, String.class);
    
    return result;
  }
  
}
