package TheArtOfJavaConcurrencyProgramming.Section83;

import TheArtOfJavaConcurrencyProgramming.Section04.SleepUtils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author zail
 * @since 2018-09-17
 */
public class SemaphoreTest {
  
  private static final int THREAD_COUNT = 30;
  private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
  private static Semaphore semaphore = new Semaphore(10);
  
  public static void main(String[] args) {
    for (int i = 0; i < THREAD_COUNT; i++) {
      threadPool.execute(() -> {
        
        try {
          semaphore.acquire();
          SleepUtils.sleep(3);
          System.out.println(Thread.currentThread().getName() + " save data.");
          semaphore.release();
        }
        catch (InterruptedException e) {
          e.printStackTrace();
        }
  
      });
    }
    
    threadPool.shutdown();
  }
  
}
