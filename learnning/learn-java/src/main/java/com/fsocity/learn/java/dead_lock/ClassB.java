package com.fsocity.learn.java.dead_lock;

/**
 * @author zail
 * @since 2018-07-22
 */
public class ClassB extends Thread {
  
  ClassA classA;
  
  public void method1() {
    synchronized(this) {
      String name = Thread.currentThread().getName();
      System.out.println(name + " entered ClassB.method1()");
      try {
        Thread.sleep(1000);
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(name + " trying to call ClassA.method2()");
      classA.method2();
    }
  }
  
  public void method2() {
    synchronized(this) {
      System.out.println("inside classB.method2()");
    }
  }
}
