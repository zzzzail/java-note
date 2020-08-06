package org.teiba.java.dsa.singleton;

/**
 * （推荐）
 * <p>
 * Holder 的模式也是高性能，并且线程安全的。
 * <p>
 * 使用静态内部类的方式，JVM 在初始化内部类的加载方式是 classLoader.
 * JVM 在初始化类的时候是但线程的，本身就会保证线程安全。
 * 就算 JVM 在初始化实例的时候，发生了重新排序的问题，也不会有线程安全的问题。
 * 因为 JVM 初始化类的时候是单线程的。
 * 只有 JVM 把类加载好之后，才会使用这个类。
 *
 * @author zail
 * @date 2020/6/20
 */
public class Singleton6 {
    
    private static class InstanceHolder {
        public static Singleton6 instance = new Singleton6();
    }
    
    private Singleton6() {
    }
    
    public static Singleton6 getInstance() {
        return InstanceHolder.instance;
    }
    
}
