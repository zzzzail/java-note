package org.teiba.java.dsa.singleton;

/**
 * 线程安全的模式（性能不高）
 * <p>
 * 使用 synchronized 给初始化实例的方法加锁，可以很好的防止多线程获取实例时初始化多个实例。
 * 但是性能非常低，因为每次需要获取实例的时候都需要抢占锁。
 *
 * @author zail
 * @date 2020/6/20
 */
public class Singleton3 {
    
    private static Singleton3 instance;
    
    private Singleton3() {
    }
    
    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        
        return instance;
    }
    
}

