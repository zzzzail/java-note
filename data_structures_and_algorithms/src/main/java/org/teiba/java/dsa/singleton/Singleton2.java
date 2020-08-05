package org.teiba.java.dsa.singleton;

/**
 * 饱汉模式
 * JVM 加载该 class 的时候就初始化实例。
 *
 * @author zail
 * @date 2020/6/20
 */
public class Singleton2 {
    
    private static Singleton2 instance;
    
    private Singleton2() {
    }
    
    public static Singleton2 getInstance() {
        return instance;
    }
}
