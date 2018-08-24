package com.fsocity.learn.java.thread;

/**
 * 线程通信 demo
 *
 * @author zail
 * @since 2018-07-08
 */
public class ThreadCommunicationDemo {
  
  public static void main(String[] args) {
    // 实例化一个产品对象, 生产者和消费者共享该实例
    Product product = new Product();
    // 指定生产线程
    Producer producer = new Producer(product);
    // 指定消费线程
    Consumer consumer = new Consumer(product);
  }
  
}
