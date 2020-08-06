package org.teiba.java.dsa.singleton;

/**
 * （推荐）
 * <p>
 * 可以使用 volatile 关键字来解决 Singleton4 出现的空指针问题。
 * 因为 volatile 关键字会让 JVM 在创建对象的时候，不发生重新排序的现象。
 * 所以解决了 Singleton4 出现的问题。
 *
 * @author zail
 * @date 2020/6/20
 */
public class Singleton5 {
    
    private static volatile Singleton5 instance;
    
    private Singleton5() {
    }
    
    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) {
                    instance = new Singleton5();
                }
            }
        }
        
        return instance;
    }
    
}
