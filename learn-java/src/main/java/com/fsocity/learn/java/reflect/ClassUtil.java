package com.fsocity.learn.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author zail
 * @since 2018-02-01
 */
public class ClassUtil {
  
  /**
   * 打印类的信息, 包括成员函数和成员变量
   * @param object
   */
  public static void printAllMessage(Object object) {
    Class clazz = getClass(object);
    
    printClassMessage(object);
  
    printMethodMessage(object);
  
    printFieldMessage(object);
  }
  
  /**
   * 打印类的信息
   *
   * @param object
   */
  public static void printClassMessage(Object object) {
    Class clazz = getClass(object);
  
    System.out.println("全类名是: " + clazz.getName());
    System.out.println("类名是: " + clazz.getSimpleName());
  }
  
  private static Class getClass(Object object) {
    /**
     * 获取类的信息(类类型)
     *
     * getClass() 方法时 Java 的本地 (native) 方法, 本地方法是使用 JNI 技术实现的, 用Java声明 C语言实现 Java中调用.
     * @see Object#getClass()
     */
    return object.getClass();
  }
  
  public static void printMethodMessage(Object object) {
    Class clazz = getClass(object);
    
    /**
     * Method 类, 方法对象
     * 一个成员方法就是一个 Method 对象.
     * getMethods() 获取的是所有的public的函数, 包括父类继承来的.
     * getDeclaredMethod() 获取所有该类自己声明的方法, 不问访问权限
     */
    // Method[] ms1 = clazz.getMethods();
    Method[] ms2 = clazz.getDeclaredMethods();
    for (Method m : ms2) {
      // 返回值类型
      System.out.print(m.getReturnType().getName() + " ");
      // 方法名
      System.out.print(m.getName());
      System.out.print("(");
      
      // 参数列表
      Class[] msParameterTypes = m.getParameterTypes();
      for (Class c : msParameterTypes) {
        System.out.print(c.getName() + ",");
      }
      
      System.out.print(")");
      System.out.println();
    }
  }
  
  public static void printFieldMessage(Object object) {
    Class clazz = getClass(object);
    
    /**
    * 获取成员变量
    * Field 封装了关于成员变量的操作
    * getField() 方法获取的是所有的public的成员变量的信息
    * getDeclaredField() 获取的是所有的本类的成员变量的信息(不包含父类的成员变量)
    */
    // Field[] fields = clazz.getFields();
    Field[] fields1 = clazz.getDeclaredFields();
    for (Field f: fields1) {
      // 得到成员变量的类类型
      Class fclazz = f.getType();
      System.out.println("成员变量的类类型名是: " + fclazz.getName());
      System.out.println("成员变量的名称是: " + f.getName());
    }
  }
  
  /**
   * 打印类的构造函数的信息
   * @param object
   */
  public static void printConstructorMessage(Object object) {
    Class clazz = getClass(object);
    
    Constructor[] constructors = clazz.getConstructors();
    
  }
}
