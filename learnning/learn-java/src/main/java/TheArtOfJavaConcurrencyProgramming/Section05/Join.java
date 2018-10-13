package TheArtOfJavaConcurrencyProgramming.Section05;

import java.util.concurrent.TimeUnit;

/**
 * @author zail
 * @since 2018-09-12
 */
public class Join {
  
  public static void main(String[] args) throws InterruptedException {
    Thread previous = Thread.currentThread();
    for (int i = 0; i < 10; i++) {
      // 每一个线程拥有前一个线程的引用, 需要等待前一个线程终止, 才能从等待中返回.
      Thread thread = new Thread(new Domino(previous), String.valueOf(i));
      thread.start();
      previous = thread;
    }
    TimeUnit.SECONDS.sleep(5);
    System.out.println(Thread.currentThread().getName() + " terminate.");
    
    // 这个方法使该线程一直不能结束
    Thread.currentThread().join();
  }
  
  static class Domino implements Runnable {
    private Thread thread;
  
    public Domino(Thread thread) {
      this.thread = thread;
    }
  
    @Override
    public void run() {
      try {
        thread.join();
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread().getName() + " terminate.");
    }
  }
}
