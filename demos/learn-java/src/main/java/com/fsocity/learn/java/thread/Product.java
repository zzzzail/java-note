package com.fsocity.learn.java.thread;

/**
 * @author zail
 * @since 2018-07-08
 */
public class Product {
  
  int n;
  
  // 为 true 时表示值可取, 为 false 时表示需要放入值
  boolean valueSet = false;
  
  // 生产方法
  public synchronized void put(int n) {
    // 如果没有值, 等待线程取值
    if (valueSet) {
      try {
        wait();
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    
    this.n = n;
    // 将 valueSet 设置为 true, 表示值已经放入
    valueSet = true;
    System.out.println(Thread.currentThread().getName() + " -- 生产: " + n);
    // 通知等待的线程, 进行取值操作
    notify();
  }
  
  // 取值方法
  public synchronized void get() {
    // 如果没有值, 等待新值放入
    if (!valueSet) {
      try {
        wait();
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  
    System.out.println(Thread.currentThread().getName() + " -- 消费: " + n);
    // 将 valueSet 设置为 false ,表示值取
    valueSet = false;
    // 通知等待的线程, 放入新值
    notify();
  }
}

