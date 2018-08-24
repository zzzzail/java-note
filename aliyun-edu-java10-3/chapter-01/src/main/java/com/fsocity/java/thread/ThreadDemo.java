package com.fsocity.java.thread;

/**
 * @author zail
 * @since 2018-06-26
 */
public class ThreadDemo {
  
  public static void main(String[] args) {
    new MyThread("线程A").start();
    new MyThread("线程B").start();
    new MyThread("线程C").start();
  }
}
