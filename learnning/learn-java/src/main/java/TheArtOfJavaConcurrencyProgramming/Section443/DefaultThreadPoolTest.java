package TheArtOfJavaConcurrencyProgramming.Section443;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zail
 * @since 2018-09-13
 */
public class DefaultThreadPoolTest {
  
  public static void main(String[] args) {
    ThreadPool<MyJob> threadPool = new DefaultThreadPool<>(10);
    
    List<MyJob> jobList = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      MyJob job = new MyJob();
      jobList.add(job);
    }
  
    for (MyJob job : jobList) {
      threadPool.execute(job);
    }
    
    // threadPool.shutdown();
  }
  
  static class MyJob implements Runnable {
    
    @Override
    public void run() {
      try {
        TimeUnit.SECONDS.sleep(1);
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": 执行完成");
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  
}
