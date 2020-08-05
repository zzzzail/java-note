package TheArtOfJavaConcurrencyProgramming.Section01;

/**
 * 死锁
 * 线程 t1 和 t2 形成了死锁
 * @author zail
 * @since 2018-07-22
 */
public class DeadLockDemo {
  
  private static String A = "A";
  
  private static String B = "B";
  
  public static void main(String[] args) {
    new DeadLockDemo().deadLock();
  }
  
  private void deadLock() {
    Thread t1 = new Thread(() -> {
      synchronized(A) {
        try {
          Thread.sleep(20000);
        }
        catch (InterruptedException e) {
          e.printStackTrace();
        }
        synchronized (B) {
          System.out.println("1");
        }
      }
    });
    
    Thread t2 = new Thread(() -> {
      synchronized (B) {
        synchronized (A) {
          System.out.println("2");
        }
      }
    });
    
    t1.start();
    t2.start();
  }
  
}
