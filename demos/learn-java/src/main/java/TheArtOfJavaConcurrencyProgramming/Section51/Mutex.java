package TheArtOfJavaConcurrencyProgramming.Section51;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author zail
 * @since 2018-09-13
 */
public class Mutex implements Lock {
  
  // 自定义的同步器(静态内部类)
  private static class Sync extends AbstractQueuedSynchronizer {
    // 是否处于占用的状态
    @Override
    protected boolean isHeldExclusively() {
      return getState() == 1;
    }
  
    // 当前状态为 0 时获取锁
    @Override
    protected boolean tryAcquire(int arg) {
      if (compareAndSetState(0, 1)) {
        setExclusiveOwnerThread(Thread.currentThread());
        return true;
      }
      return false;
    }
  
    // 释放锁, 将状态设置为 0
    @Override
    protected boolean tryRelease(int arg) {
      if (getState() == 0) throw new IllegalArgumentException();
      
      setExclusiveOwnerThread(null);
      setState(0);
      return true;
    }
    
    // 返回一个 Condition, 每一个 condition 都包含了一个 condition 队列
    public Condition newCondition() {
      return new ConditionObject();
    }
  }
  
  // 将操作代理到 Sync 上
  private final Sync sync = new Sync();
  
  @Override
  public void lock() {
    sync.acquire(1);
  }
  
  @Override
  public void lockInterruptibly() throws InterruptedException {
    sync.acquireInterruptibly(1);
  }
  
  @Override
  public boolean tryLock() {
    return sync.tryAcquire(1);
  }
  
  @Override
  public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
    return sync.tryAcquireNanos(1, unit.toNanos(time));
  }
  
  @Override
  public void unlock() {
    sync.release(1);
  }
  
  @Override
  public Condition newCondition() {
    return sync.newCondition();
  }
}
