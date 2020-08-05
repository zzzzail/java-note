package org.teiba.java.dsa.singleton;

/**
 * 最简单的单例模式，俗称懒汉模式
 * 只有当需要获取该实例的时候才会初始化实例。所以叫懒汉模式。
 *
 * @author zail
 * @date 2020/6/20
 */
public class Singleton1 {
    
    private static Singleton1 instance;
    
    private Singleton1() {
    }
    
    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        
        return instance;
    }
}
