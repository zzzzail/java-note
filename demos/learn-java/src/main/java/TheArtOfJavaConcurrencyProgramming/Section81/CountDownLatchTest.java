package TheArtOfJavaConcurrencyProgramming.Section81;

import java.util.concurrent.CountDownLatch;

/**
 * @author zail
 * @since 2018-09-17
 */
public class CountDownLatchTest {
  
  static CountDownLatch countDownLatch = new CountDownLatch(2);
  
  public static void main(String[] args) throws InterruptedException {
    new Thread(() -> {
      System.out.println(1);
      countDownLatch.countDown();
      System.out.println(2);
      countDownLatch.countDown();
    }).start();
    
    countDownLatch.await();
    System.out.println(3);
    
  }
  
}
