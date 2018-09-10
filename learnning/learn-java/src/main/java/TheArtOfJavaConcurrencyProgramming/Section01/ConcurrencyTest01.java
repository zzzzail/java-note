package TheArtOfJavaConcurrencyProgramming.Section01;

/**
 * @author zail
 * @since 2018-07-22
 */
public class ConcurrencyTest01 {
  
  private static final long count = 10000;
  
  public static void main(String[] args) throws InterruptedException {
    concurrency();
    serial();
  }
  
  private static void concurrency() throws InterruptedException {
    long start = System.currentTimeMillis();
    Thread thread = new Thread(() -> {
      int a = 0;
      for (long i = 0; i < count; i++) {
        a += 5;
      }
    });
    
    thread.start();
    
    int b = 0;
    for (long i = 0; i < count; i++) {
      b--;
    }
    long time = System.currentTimeMillis() - start;
    thread.join(); // 让线程进入永远等待的状态
    System.out.println("concurrency: " + time + "ms, b = " + b);
  }
  
  private static void serial() {
    long start = System.currentTimeMillis();
    int a = 0;
    
    for (long i = 0; i < count; i++) {
      a += 5;
    }
    int b = 0;
    for (long i = 0; i < count; i++) {
      b--;
    }
    
    long time = System.currentTimeMillis() - start;
    System.out.println("serial: " + time + "ms, b = " + b + ", a = " + a);
  }
  
}
