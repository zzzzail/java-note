package com.fsocity.learn.java;

import java.util.Date;

/**
 * @author zail
 * @since 2018-02-02
 */
public class Demo01 {
  
  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      System.out.println(new Date());
      try {
        Thread.sleep(100);
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
