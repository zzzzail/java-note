package com.fsocity.learn.java.thread;

/**
 * 生产者
 * @author zail
 * @since 2018-07-08
 */
public class Producer implements Runnable {
  
  private Product product;
  
  public Producer(Product product) {
    this.product = product;
    new Thread(this, "Producer").start();
  }
  
  @Override
  public void run() {
    int k = 0;
    // 生产10次
    for (int i = 0; i < 10; i++) {
      product.put(k++);
    }
  }
}
