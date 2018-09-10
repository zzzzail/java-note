package TheArtOfJavaConcurrencyProgramming.Section02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zail
 * @since 2018-08-24
 */
public class Counter {
  
  private AtomicInteger atomicInteger = new AtomicInteger(0);
  
  private int i = 0;
  
  public static void main(String[] args) {
    final Counter cas = new Counter();
    List<Thread> ts = new ArrayList<>(600);
    long start = System.currentTimeMillis();
    for (int j = 0; j < 100; j++) {
      Thread t = new Thread(() -> {
        for (int i = 0; i < 10000; i++) {
          cas.count();
          cas.safeCount();
        }
      });
      ts.add(t);
    }
    for (Thread t : ts) {
      t.start();
    }
    // 等待 所有 线程 执行 完成
    for (Thread t : ts) {
      try {
        t.join();
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("非线程安全计数器结果: " + cas.i);
    System.out.println("线程安全计数器结果: " + cas.atomicInteger.get());
    System.out.println("用时: " + (System.currentTimeMillis() - start) + "毫秒");
  }
  
  /**
   * 使用 CAS 实现线程安全计数器
   */
  private void safeCount() {
    for (; ; ) {
      int i = atomicInteger.get();
      boolean suc = atomicInteger.compareAndSet(i, ++i);
      if (suc) {
        break;
      }
    }
  }
  
  /**
   * 非线程安全的计数器
   */
  private void count() {
    i++;
  }
  
}