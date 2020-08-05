package TheArtOfJavaConcurrencyProgramming.Section05;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zail
 * @since 2018-09-12
 */
public class ConnectionTest {
  
  static ConnectionPool pool = new ConnectionPool(10);
  // 保证所有的 ConnectionRunner 能够同时开始
  static CountDownLatch start = new CountDownLatch(1);
  // main 线程将会等待所有 ConnectionRunner 结束后才能继续执行.
  static CountDownLatch end;
  
  public static void main(String[] args) throws InterruptedException {
    int threadCount = 10;
    end = new CountDownLatch(threadCount);
    int count = 20;
    AtomicInteger got = new AtomicInteger();
    AtomicInteger notGot = new AtomicInteger();
    for (int i = 0; i < threadCount; i++) {
      Thread thread = new Thread(new ConnectionRunner(count, got, notGot),
        "ConnectionRunnerThread");
      thread.start();
    }
    start.countDown();
    end.await();
    System.out.println(" total invoke: " + (threadCount * count));
    System.out.println(" got connection: " + got);
    System.out.println(" not got connection " + notGot);
  }
  
  static class ConnectionRunner implements Runnable {
    
    int count;
    AtomicInteger got;
    AtomicInteger notGot;
    
    public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
      this.count = count;
      this.got = got;
      this.notGot = notGot;
    }
    
    @Override
    public void run() {
      try {
        start.await();
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
      while (count > 0) {
        // 从线程池获取链接, 如果1000ms内无法获得到, 将会返回 null
        // 分别统计链接获取的数量 got 和未获取到的数量 notGot
        try {
          Connection connection = pool.fetchConnection(1000);
          if (connection != null) {
            try {
              connection.createStatement();
              connection.commit();
            }
            catch (SQLException e) {
              e.printStackTrace();
            }
            finally {
              pool.releaseConnection(connection);
              got.incrementAndGet();
            }
          }
          else {
            notGot.incrementAndGet();
          }
        }
        catch (InterruptedException e) {
          e.printStackTrace();
        }
        finally {
          count--;
        }
      }
      
      end.countDown();
    }
  }
  
}
