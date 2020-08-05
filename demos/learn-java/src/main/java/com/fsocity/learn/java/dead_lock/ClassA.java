package com.fsocity.learn.java.dead_lock;

/**
 * @author zail
 * @since 2018-07-22
 */
public class ClassA extends Thread {
  
  ClassB classB;
  
  public void method1() {
    synchronized(this) {
      String name = Thread.currentThread().getName();
      System.out.println(name + " entered ClassA.method1()");
      try {
        Thread.sleep(1000);
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(name + " trying to call ClassB.method2()");
      classB.method2();
    }
  }
  
  public void method2() {
    synchronized(this) {
      System.out.println("inside classA.method2()");
    }
  }
}
