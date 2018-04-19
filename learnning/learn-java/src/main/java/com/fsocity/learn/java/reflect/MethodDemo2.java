package com.fsocity.learn.java.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zail
 * @since 2018-02-02
 */
public class MethodDemo2 {
  
  /**
   * 通过Class,Method来认识泛型的本质
   */
  public static void main(String[] args) {
    List list = new ArrayList();
    
    List<String> list1 = new ArrayList<String>();
    list1.add("hello");
    // list1.add(20); 为什么会错误, 怎么实现的?
    // 1. 首先判断两个对象的class参数是否相等
    Class c1 = list.getClass();
    Class c2 = list1.getClass();
    System.out.println(c1 == c2);
    
    /**
     * 反射的操作都是编译之后的操作
     * c1==c2 结果返回true, 说明编译之后集合的泛型是去泛型化的, (编译之后就没有泛型了)
     * Java 中集合的泛型, 是防止错误输入的, 只在编译阶段有效, 绕过编译就无效了.
     *
     * 验证: 我们可以通过方法的反射来操作, 绕过编译
     */
    try {
      Method method = c1.getMethod("add", Object.class);
      method.invoke(list1, 20);
      System.out.println(list1.size());
      System.out.println(list1);
      // System.out.println(list1.get(1));
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
