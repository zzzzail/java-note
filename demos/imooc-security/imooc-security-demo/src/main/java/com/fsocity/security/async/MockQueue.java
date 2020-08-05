package com.fsocity.security.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author zail
 * @since 2017-12-26
 */
@Component
@Slf4j
public class MockQueue {
  
  private String placeOrder;
  
  private String completeOrder;
  
  public String getPlaceOrder() {
    return placeOrder;
  }
  
  public void setPlaceOrder(String placeOrder) {
    
    new Thread(() -> {
      
      log.info("接到下单请求, orderNumber: {}", placeOrder);
      try {
        Thread.sleep(1000);
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
      this.completeOrder = placeOrder;
      log.info("下单请求处理完毕, orderNumber: {}", placeOrder);
      
    }).start();
  }
  
  public String getCompleteOrder() {
    return completeOrder;
  }
  
  public void setCompleteOrder(String completeOrder) {
    this.completeOrder = completeOrder;
  }
}
