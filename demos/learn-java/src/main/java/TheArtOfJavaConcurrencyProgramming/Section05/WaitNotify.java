package TheArtOfJavaConcurrencyProgramming.Section05;

import TheArtOfJavaConcurrencyProgramming.Section04.SleepUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author zail
 * @since 2018-09-10
 */
public class WaitNotify {
  
  static boolean flag = true;
  static Object lock = new Object();
  
  public static void main(String[] args) throws InterruptedException {
    Thread waitThread = new Thread(new Wait(), "WaitThread");
    waitThread.start();
    TimeUnit.SECONDS.sleep(5);
    Thread notifyThread = new Thread(new Notify(), "NotifyThread");
    notifyThread.start();
  }
  
  static class Wait implements Runnable {
    @Override
    public void run() {
      // 加锁, 拥有 lock 的 Monitor
      synchronized (lock) {
        // 当满足条件时, 继续 wait, 同时释放 lock 锁.
        while (flag) {
          System.out.println(Thread.currentThread() + " flag is true. wait @ " +
            new SimpleDateFormat(" HH:mm:ss").format(new Date()));
          try {
            lock.wait();
          }
          catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        // 条件满足时, 完成工作
        System.out.println(Thread.currentThread() + " flag is false. running @ " +
          new SimpleDateFormat(" HH:mm:ss").format(new Date()));
      }
    }
  }
  
  static class Notify implements Runnable {
    @Override
    public void run() {
      // 加锁, 拥有 lock 的 Monitor
      synchronized (lock) {
        // 获取 lock 锁,后进行通知, 通知后不会释 lock 放锁,
        // 知道当前线程释放了 lock 锁后, WaitThread 才能从 wait 方法中返回
        System.out.println(Thread.currentThread() + " hold lock. notify @ " +
          new SimpleDateFormat(" HH: mm: ss").format(new Date()));
        lock.notifyAll();
        flag = false;
        SleepUtils.sleep(5);
      }
      
      // 再次加锁
      synchronized (lock) {
        System.out.println(Thread.currentThread() + " hold lock again. sleep @ " +
          new SimpleDateFormat(" HH: mm: ss").format(new Date()));
        SleepUtils.sleep(5);
        // 最后才释放锁
      }
    }
  }
}
