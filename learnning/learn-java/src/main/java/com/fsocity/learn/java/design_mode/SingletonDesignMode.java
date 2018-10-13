package com.fsocity.learn.java.design_mode;

/**
 * 单例设计模式
 *
 * @author zail
 * @since 2018-09-28
 */
public class SingletonDesignMode {
  
  // 测试
  public static void main(String[] args) {
  
    // 单实例
    HungrySingleton hungrySingleton = HungrySingleton.getInstance();
    HungrySingleton hungrySingleton1 = HungrySingleton.getInstance();
    
    if (hungrySingleton.equals(hungrySingleton1)) {
      System.out.println("HungrySingleton 是单例的类");
    }
    else {
      System.out.println("HungrySingleton 不是单例的类");
    }
  
  
    LazySingleton lazySingleton = LazySingleton.getInstance();
    LazySingleton lazySingleton1 = LazySingleton.getInstance();
    if (lazySingleton.equals(lazySingleton1)) {
      System.out.println("LazySingleton 是单例的类");
    }
    else {
      System.out.println("LazySingleton 不是单例的类");
    }
  
  }
  
  /**
   * 单例模式类, (饿汉模式)
   * 整个应用程序中, 有且只有一个该类的实例, 这种设计模式称之为单例模式.
   *
   * 为什么叫饿汉模式?
   * 在 Java 虚拟机把类初始化时就创建类的实例, 后来调用返回该创建好的实例, 就是饿汉模式.
   * Java 虚拟机在应用程序启动之前会先扫描类文件, 把类文件对象存储到 Java 虚拟机中以便以后使用,
   * 当类对象存储到 Java 虚拟机时会初始化静态字段, 初始化后则生成了实例.
   */
  static class HungrySingleton {
    
    private static HungrySingleton instance = new HungrySingleton();
    
    // 私有化构造方法, 使其不能在外部创建新的实例
    private HungrySingleton() {}
  
    public static HungrySingleton getInstance() {
      return instance;
    }
  }
  
  /**
   * 单例模式类, (懒汉模式)
   * 为什么叫懒汉模式?
   * 该单例类的实例不会随着应用程序的初始化而创建的,
   * 也就是说, 在应用程序加载完后, instance 的值是 null.
   * 只有当应用程序中第一次需要用到该实例时才会初始化该实例.
   */
  static class LazySingleton {
  
    private static LazySingleton instance;
    
    // 私有化构造方法
    private LazySingleton() {}
    
    private static LazySingleton getInstance() {
      if (instance == null) {
        instance = new LazySingleton();
      }
      
      return instance;
    }
  
  }
  
}
