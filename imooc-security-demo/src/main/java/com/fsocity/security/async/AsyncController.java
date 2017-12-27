package com.fsocity.security.async;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * 异步处理
 * @author zail
 * @since 2017-12-26
 */
@RestController
@Slf4j
public class AsyncController {

  @Autowired
  private MockQueue mockQueue;
  
  @Autowired
  private DeferredResultHolder deferredResultHolder;
  
  @RequestMapping("/order")
  public DeferredResult<String> order() {
    log.info("主线程开始");
    
    // 使用子线程, 使请求异步执行
    // Callable<String> result = new Callable<String>() {
    //   @Override
    //   public String call() throws Exception {
    //     log.info("子线程开始");
    //     Thread.sleep(1000);
    //     log.info("子线程返回");
    //     return null;
    //   }
    // };
    
    String orderNumber = RandomStringUtils.randomNumeric(8);
    mockQueue.setPlaceOrder(orderNumber);
    
    DeferredResult<String> result = new DeferredResult<>();
    deferredResultHolder.getMap().put(orderNumber, result);
    
    log.info("主线程返回");
    return result;
  }

}
