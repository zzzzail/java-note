package com.fsocity.java.thread;

/**
 * @author zail
 * @since 2018-06-26
 */
public class MyThread extends Thread {
  
  private String title;
  
  public MyThread(String title) {
    this.title = title;
  }
  
  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println(title + "运行: i = " + i);
    }
  }
}
