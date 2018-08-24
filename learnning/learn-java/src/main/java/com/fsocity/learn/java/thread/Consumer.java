package com.fsocity.learn.java.thread;

/**
 * @author zail
 * @since 2018-07-08
 */
public class Consumer implements Runnable {
  
  private Product product;
  
  public Consumer(Product product) {
    this.product = product;
    new Thread(this, "Consumer").start();
  }
  
  @Override
  public void run() {
    // 消费10次
    for (int i = 0; i < 10; i++) {
      product.get();
    }
  }
}
