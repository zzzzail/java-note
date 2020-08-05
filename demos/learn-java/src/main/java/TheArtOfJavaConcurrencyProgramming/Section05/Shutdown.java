package TheArtOfJavaConcurrencyProgramming.Section05;

import java.util.concurrent.TimeUnit;

/**
 * @author zail
 * @since 2018-09-10
 */
public class Shutdown {
  
  public static void main(String[] args) throws InterruptedException {
    Runner one = new Runner();
    Thread countThread = new Thread(one, "CountThread");
    countThread.start();
    
    // 睡眠 1 秒钟, main 线程对 CountThread 进行中断, 使 CountThread 能够感知中断而结束
    TimeUnit.SECONDS.sleep(1);
    countThread.interrupt();
    
    Runner two = new Runner();
    countThread = new Thread(two, "CountThread");
    countThread.start();
    // 睡眠 1 秒钟, main 线程对 CountThread 进行中断, 使 CountThread 能够感知 on 为 false 而结束
    TimeUnit.SECONDS.sleep(1);
    two.cancel();
  }
  
  static class Runner implements Runnable {
    private long i;
    private volatile boolean on = true;
    
    @Override
    public void run() {
      while (on && !Thread.currentThread().isInterrupted()) {
        i++;
      }
      System.out.println("Count i = " + i);
    }
    
    public void cancel() {
      on = false;
    }
  }
  
}
