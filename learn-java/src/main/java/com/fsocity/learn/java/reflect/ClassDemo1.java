package com.fsocity.learn.java.reflect;

/**
 * @author zail
 * @since 2018-01-29
 */
public class ClassDemo1 {
  
  public static void main(String[] args)
    throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    
    // Foo 的实例如何表示
    Foo foo1 = new Foo(); // foo1就表示c胡来了.
  
    /**
     * Foo 这个类也是一个实例对象, Class类的实例对象, 如何表示呢?
     * 任何一个类都是Class的实例对象, 这个实例对象有三种表现方式
     */
    
    // 1, 任何一个类都有一个隐含的静态成员变量 class
    Class clazz1 = Foo.class;
    
    // 2, 已知该类的对象, 通过getClass()方法获取
    Class clazz2 = foo1.getClass();
  
    /**
     * clazz1, clazz2 表示了Foo类的类类型(class type).
     * 万事万物皆对象, 类本身也是一个对象, 是Class类的实例对象.
     * 这个对象我们成为该类的类类型.
     */
    System.out.println(clazz1 == clazz2);
    
    // 3, Class.forName() 方法
    Class clazz3 = Class.forName("com.fsocity.learn.java.reflect.Foo");
    System.out.println(clazz3);
    System.out.println(clazz2 == clazz3);
    
    // 我们完全可以通过类的类类型, 创建该类的对象 --> 通过 clazz1、clazz2、clazz3 创建 Foo 类的对象
    Foo foo2 = (Foo) clazz3.newInstance(); // 获取的Foo类的实例(前提是要有无参数的构造方法)
    System.out.println(foo2.num);
  }
}

class Foo {
  public int num = 10;
}
