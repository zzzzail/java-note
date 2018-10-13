package com.fsocity.learn.java;

/**
 * @author zail
 * @since 2018-09-28
 */
public class ForIntMaxValue {
  
  public static void main(String[] args) {
    long sum = 0L;
    for (int i = 0; i < Integer.MAX_VALUE; i++) {
      sum += i;
    }
  
    System.out.println(sum);
  }
}
