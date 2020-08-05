package TheArtOfJavaConcurrencyProgramming.Section522;

import TheArtOfJavaConcurrencyProgramming.Section04.SleepUtils;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.concurrent.locks.Lock;

/**
 * @author zail
 * @since 2018-09-15
 */
public class TwinsLockTest {
  
  @Test
  public void test() throws InterruptedException {
    final Lock lock = new TwinsLock();
    
    class Worker extends Thread {
      @Override
      public void run() {
        while (true) {
          lock.lock();
          try {
            System.out.println(Thread.currentThread().getName() + " 线程开始等待");
            SleepUtils.sleep(1);
            System.out.println(Thread.currentThread().getName() + " 线程结束等待");
          }
          catch (Exception e) {
            e.printStackTrace();
          }
          finally {
            lock.unlock();
          }
        }
      }
    }
    
    // 启动10个线程
    for (int i = 0; i < 10; i++) {
      Worker worker = new Worker();
      worker.setDaemon(true);
      worker.start();
    }
    
    // 每隔一秒换行
    for (int i =0 ; i<10 ; i++) {
      SleepUtils.sleep(1);
      System.out.println();
    }
    
    Thread.currentThread().join();
  }
  
}
