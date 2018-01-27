package com.fsocity.learn.java;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation;

import java.lang.Exception;
import java.util.List;

/**
 *   Throwable
 *   ↓      ↓
 * Error  Exception
 *
 * Error: 虚拟机错误和线程死锁, 一旦出现程序就会彻底挂了.
 * Exception: 编码、环境或者用户的输入出现问题
 *   RuntimeException: 是非检查异常: 空指针异常NullPointerException, 数组下标越界异常ArrayIndexOutOfBoundsException
 *                     类型转换异常ClassCastException, 算数异常ArithmeticException,
 *                     这些异常会由java虚拟机自动抛出, 自动捕获.
 *   其它的异常都是检查异常: 文件不存在,sql异常等, 需要手动添加捕获语句以及处理语句
 * @author zail
 * @since 2018-01-26
 */
public class LearnException extends Exception {
  
  /**
   * 空指针异常
   */
  public void nullPointerException() {
    String str = null;
    System.out.println(str.length());
  }
  
  /**
   * 数组下标越界异常
   */
  public void arrayIndexOutOfBoundsException() {
    int[] arr = new int[]{1, 2, 3};
    for (int i = 0; i < arr.length + 1; i++) {
      System.out.println(arr[i]);
    }
  }
  
  /**
   * 类型转换异常
   */
  public void classCastException() {
    Animal dog = new Dog();
    Animal cat = new Cat();
    Dog dog1 = (Dog) dog;
    Dog dog2 = (Dog) cat;
  }
  
  /**
   * 算数异常
   */
  public void arithmeticException() {
    int one = 1;
    int zero = 0;
    System.out.println(one / zero);
  }
  
  public static void main(String[] args) {
    LearnException learnException = new LearnException();
    // learnException.nullPointerException();
    // learnException.arrayIndexOutOfBoundsException();
    // learnException.classCastException();
    // learnException.arithmeticException();
    
    try {
      System.out.println("");
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      System.out.println("123");
    }
  }
}

class Animal {}

class Dog extends Animal {}

class Cat extends Animal {}
