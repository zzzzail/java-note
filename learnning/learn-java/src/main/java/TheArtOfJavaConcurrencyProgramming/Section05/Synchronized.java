package TheArtOfJavaConcurrencyProgramming.Section05;

/**
 * @author zail
 * @since 2018-09-10
 */
public class Synchronized {
  
  public static void main(String[] args) {
    // 对 class 对象进行加锁
    synchronized (Synchronized.class) {
    }
    
    // 静态同步方法, 对 Synchronized Class 对象进行加锁
    m();
  }
  
  public static synchronized void m() {
  }
  
}
