package com.fsocity.learn.java.dead_lock;

/**
 * 死锁
 * 1. 竞速线程(RacingThread)运行 classB.method1() 拿到 ClassB 的锁后
 *    (这时 classB 对象已被锁住, 如果方法不执行完成, 则不会释放 classB 对象的锁),
 *    运行到最后一句 classA.method2 到最后一句, 去尝试运行 classA 的有锁方法,
 *    这时的 classA 已经被主线程(查看步骤2)锁住, 还未释放 classA 对象的锁.
 *
 * 2. 主线程(MainThread)运行 classA.method1() 拿到 classA 对象的锁后
 *    (这时 classA 对象已被锁住, 如方法不执行完成, 则不会释放 classA 对象的锁),
 *    运行到最后一句 classB.method2(), 去尝试运行 classB 的有锁方法,
 *    这时的 classB 已经被竞速线程(查看步骤1)锁住, 还未释放 classB 对象的锁.
 *
 * 如上产生的后果就是:
 *    主线程锁住 classB 想要 classA 的锁
 *    同时
 *    竞速线程锁住 classA 想要 classB 的锁
 *    这时候主线程说: 你不释放 classA 的锁我就不能给你 classB 的锁, 我就要一直锁住它!
 *    竞速线程说: 你不释放 classB 的锁我就不能给你 classA 的锁, 我也要一直锁住它! 谁怕谁 GG
 *
 * 这就叫死锁
 *
 * @author zail
 * @since 2018-07-22
 */
public class DeadLock implements Runnable {
  
  private ClassA classA = new ClassA();
  
  private ClassB classB = new ClassB();
  
  public DeadLock() {
    Thread.currentThread().setName("MainThread");
    classA.classB = classB;
    classB.classA = classA;
    new Thread(this).start();
    classA.method1();
    System.out.println("back to main thread.");
  }
  
  public static void main(String[] args) {
    DeadLock d = new DeadLock();
  }
  
  @Override
  public void run() {
    Thread.currentThread().setName("RacingThread");
    classB.method1();
    System.out.println("back to racing thread.");
  }
}
