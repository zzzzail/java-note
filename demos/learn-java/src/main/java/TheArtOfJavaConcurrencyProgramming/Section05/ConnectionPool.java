package TheArtOfJavaConcurrencyProgramming.Section05;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @author zail
 * @since 2018-09-12
 */
public class ConnectionPool {
  
  private LinkedList<Connection> pool = new LinkedList<>();
  
  public ConnectionPool(int initialSize) {
    if (initialSize > 0) {
      for (int i = 0; i < initialSize; i++) {
        pool.addLast(ConnectionDriver.createConnection());
      }
    }
  }
  
  public void releaseConnection(Connection connection) {
    if (connection != null) {
      synchronized (pool) {
        // 链接释放后需要进行通知,这样其它消费者能感知到线程池中已归还了一个线程.
        pool.addLast(connection);
        pool.notifyAll();
      }
    }
  }
  
  public Connection fetchConnection(long mills) throws InterruptedException {
    synchronized (pool) {
      // 完全超时
      if (mills <= 0) {
        while (pool.isEmpty()) {
          pool.wait();
        }
        return pool.removeFirst();
      }
      else {
        long future = System.currentTimeMillis() + mills;
        long remaining = mills;
        while (pool.isEmpty() && remaining > 0) {
          pool.wait(remaining);
          remaining = future - System.currentTimeMillis();
        }
        Connection result = null;
        if (!pool.isEmpty()) {
          result = pool.removeFirst();
        }
        return result;
      }
    }
  }
  
}
