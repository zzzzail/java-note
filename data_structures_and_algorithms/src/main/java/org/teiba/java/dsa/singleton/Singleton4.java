package org.teiba.java.dsa.singleton;

/**
 * 双重检验锁模式 double check
 * （提高了性能）
 * 第一个线程: 1. 进入方法
 * 2. 判断实例不存在
 * 3. 获取到锁
 * 4. 再次判断实例不存在
 * 5. 初始化实例
 * 6. 返回初始化的实例
 * 第二个线程: 1. 进入方法
 * 2. 判断实例不存在
 * 3. 获取到锁
 * 4. 判断实例存在
 * 6. 返回初始化的实例
 * 第三个线程: 1. 进入方法
 * 2. 判断实例存在
 * 6. 返回初始化的实例
 * <p>
 * 实际上这种模式是有线程安全的问题的
 * 首先要了解 JVM 创建对象的步骤：
 * 1. 分配内存空间
 * 2. 初始化对象
 * 3. 将内存空间的地址赋值给对象的引用
 * 但是 JVM 虚拟机为了提高性能，可能会对初始化对象的三个步骤进行重新排序。
 * 重新排序之后就会变成 1 -> 3 -> 2
 * <p>
 * 如果第一个线程抢到锁之后，初始化对象的时候 JVM 把初始化对象的步骤进行了重新排序。
 * 就是说这个时候对象还没有被初始化，但是内容空间的地址已经赋值给了对象的引用。（这时候对象判断的时候不为空，但实际上对象是为空的。）
 * 这时当第二个线程遇到 2（第一个if）的时候，判断该实例不为空，直接返回该实例。
 * 如果这时候第一个线程还没有执行完 5 （初始化对象）。就会造成第二个线程拿到了一个空的对象，造成空指针异常。
 *
 * @author zail
 * @date 2020/6/20
 */
public class Singleton4 {
    
    public static Singleton4 instance;
    
    private Singleton4() {
    }
    
    public static Singleton4 getInstance() {    // 1
        if (instance == null) {                   // 2
            synchronized (Singleton4.class) {       // 3
                if (instance == null) {               // 4
                    instance = new Singleton4();        // 5
                }
            }
        }
        
        return instance;                          // 6
    }
}
