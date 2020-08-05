package com.fsocity.learn.java.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zail
 * @since 2018-02-02
 */
public class MethodDemo1 {
  
  public static void main(String[] args) {
    
    // 获取print(int, int)方法, 获取一个方法就是获取类的信息, 首先要获取类的类类型, 再获取方法
    A a1 = new A();
    Class clazz = a1.getClass();
    
    /**
     * 获取方法, 名称和参数列表来决定
     * getMethod获取的是public的方法
     * getDeclaredMethod()自己声明的方法
     */
    try {
      Method method = clazz.getDeclaredMethod("print", int.class, int.class);
      
      // 方法的反射操作, 方法没有返回值则返回null, 有返回值返回具体的返回值
      // Object result = method.invoke(a1, new Object[]{10, 20});
      Object result = method.invoke(a1, 10, 20);
      
      // 获取print(String, String)方法
      Method method1 = clazz.getDeclaredMethod("print", String.class, String.class);
      Object result1 = method1.invoke(a1, "str", "sTR");
    }
    catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }
  
}

class A {
  public void print(int a, int b) {
    System.out.println(a + b);
  }
  
  public void print(String a, String b) {
    System.out.println(a.toUpperCase() + " " + b.toLowerCase());
  }
}
