package TheArtOfJavaConcurrencyProgramming.Section522;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author zail
 * @since 2018-09-15
 */
public class TwinsLock implements Lock {
  
  private final Sync sync = new Sync(2);
  
  private static final class Sync extends AbstractQueuedSynchronizer {
    Sync(int count) {
      if (count <= 0) {
        throw new IllegalArgumentException("count must large than zero.");
      }
      setState(count);
    }
    
    @Override
    public int tryAcquireShared(int reduceCount) {
      for (; ; ) {
        int current = getState();
        int newCount = current - reduceCount;
        if (newCount < 0 || compareAndSetState(current, newCount)) {
          return newCount;
        }
      }
    }
    
    @Override
    public boolean tryReleaseShared(int reduceCount) {
      for (; ; ) {
        int current = getState();
        int newCount = current + reduceCount;
        if (compareAndSetState(current, newCount)) {
          return true;
        }
      }
    }
  }
  
  @Override
  public void lock() {
    sync.tryAcquireShared(1);
  }
  
  @Override
  public void lockInterruptibly() throws InterruptedException {
  
  }
  
  @Override
  public boolean tryLock() {
    return false;
  }
  
  @Override
  public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
    return false;
  }
  
  @Override
  public void unlock() {
    sync.releaseShared(1);
  }
  
  @Override
  public Condition newCondition() {
    return null;
  }
}
