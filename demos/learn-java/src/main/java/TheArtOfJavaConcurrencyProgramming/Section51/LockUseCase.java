package TheArtOfJavaConcurrencyProgramming.Section51;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zail
 * @since 2018-09-13
 */
public class LockUseCase {
  
  public static void main(String[] args) {
    Lock lock = new ReentrantLock();
    lock.lock();
    
    try {
    }
    finally {
      lock.unlock();
    }
  }
}
