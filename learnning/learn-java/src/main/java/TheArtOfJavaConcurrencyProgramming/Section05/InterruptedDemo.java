package TheArtOfJavaConcurrencyProgramming.Section05;

import TheArtOfJavaConcurrencyProgramming.Section04.SleepUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author zail
 * @since 2018-09-07
 */
public class InterruptedDemo {
  
  public static void main(String[] args) throws InterruptedException {
    // sleepThread 不停的睡觉
    Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
    sleepThread.setDaemon(true);
    // busyThread 不停地运行
    Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
    busyThread.setDaemon(true);
    
    sleepThread.start();
    busyThread.start();
  
    TimeUnit.SECONDS.sleep(5);
    
    // 终端线程
    sleepThread.interrupt();
    busyThread.interrupt();
  
    System. out. println(" SleepThread interrupted is " + sleepThread. isInterrupted());
    System. out. println(" BusyThread interrupted is " + busyThread. isInterrupted());
    
    // 防止 sleepThread 和 busyThread 立刻 退出
    SleepUtils.sleep(2);
  }
  
  // 一直睡觉的线程
  static class SleepRunner implements Runnable {
    @Override
    public void run() {
      while (true) {
        SleepUtils.sleep(10);
      }
    }
  }
  
  // 忙碌的线程
  static class BusyRunner implements Runnable {
    @Override
    public void run() {
      while (true) { }
    }
  }
  
}
