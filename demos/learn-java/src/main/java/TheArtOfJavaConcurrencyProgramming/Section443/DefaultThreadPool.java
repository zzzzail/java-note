package TheArtOfJavaConcurrencyProgramming.Section443;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 默认线程池的实现类
 *
 * @author zail
 * @since 2018-09-13
 */
public class DefaultThreadPool<JOB extends Runnable> implements ThreadPool<JOB> {
  
  // 线程池最大限制数
  private static final int MAX_WORKER_NUMBERS = 10;
  
  // 线程池默认的数量
  private static final int DEFAULT_WORKER_NUMBERS = 5;
  
  // 线程池最小的数量
  private static final int MIN_WORKER_NUMBERS = 1;
  
  /**
   * 工作列表, 往里插入一个 job 后在这里等待执行,
   * 执行 job 完成后则将该 job 从工作列表中删除.
   */
  private final LinkedList<JOB> jobs = new LinkedList<>();
  
  /**
   * 工作者列表, 这里使用同步的列表作为工作者列表.
   */
  private final List<Worker> workers = Collections.synchronizedList(new ArrayList<>());
  
  // 工作者线程的数量
  private int workerNum = DEFAULT_WORKER_NUMBERS;
  
  private AtomicLong threadNum = new AtomicLong();
  
  public DefaultThreadPool() {
    initializeWorkers(DEFAULT_WORKER_NUMBERS);
  }
  
  public DefaultThreadPool(int workerNum) {
    this.workerNum = workerNum > MAX_WORKER_NUMBERS ?
      workerNum < MIN_WORKER_NUMBERS ?
        MIN_WORKER_NUMBERS : workerNum : workerNum;
    
    initializeWorkers(workerNum);
  }
  
  @Override
  public void execute(JOB job) {
    if (job != null) {
      // 添加一个工作, 然后进行通知
      synchronized (jobs) {
        jobs.addLast(job);
        jobs.notify();
      }
    }
  }
  
  @Override
  public void shutdown() {
    for (Worker worker : workers) {
      worker.shutdown();
    }
  }
  
  @Override
  public void addWorkers(int num) {
    synchronized (jobs) {
      // 限制新增的 worker 数量不能超过最大值
      if (num + this.workerNum > MAX_WORKER_NUMBERS) {
        num = MAX_WORKER_NUMBERS - this.workerNum;
      }
      
      initializeWorkers(num);
      this.workerNum += num;
    }
  }
  
  @Override
  public void removeWorkers(int num) {
    synchronized (jobs) {
      // 限制删除的 worker 不能小于最小值
      if (num >= this.workerNum) {
        throw new IllegalArgumentException("Beyond workerNum.");
      }
      
      // 按照给定的数量停止 worker
      int count = 0;
      while (count < num) {
        Worker worker = workers.get(count);
        if (workers.remove(worker)) {
          worker.shutdown();
          count++;
        }
      }
      
      this.workerNum -= count;
    }
  }
  
  @Override
  public int getJobSize() {
    return this.jobs.size();
  }
  
  /**
   * 初始化线程工作者
   *
   * @param workerNum
   */
  private void initializeWorkers(int workerNum) {
    for (int i = 0; i < workerNum; i++) {
      Worker worker = new Worker();
      workers.add(worker);
      Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet());
      thread.start();
    }
  }
  
  /**
   * 工作者, 负责消费任务
   */
  class Worker implements Runnable {
    
    // 是否工作中的状态
    private volatile boolean running = true;
    
    @Override
    public void run() {
      while (running) {
        JOB job = null;
        synchronized (jobs) {
          // 如果工作者列表为空, 就 wait
          while (jobs.isEmpty()) {
            try {
              jobs.wait();
            }
            catch (InterruptedException e) {
              // 感知到外部对 WorkerThread 的中断操作, 返回
              Thread.currentThread().interrupt();
              return;
            }
          }
          
          // 取出一个 job
          job = jobs.removeFirst();
        }
        
        if (job != null) {
          try {
            job.run();
          }
          catch (Exception e) { // 忽略 job 中的 Exception
          }
        }
        
      }
    }
    
    // 关闭线程方法
    public void shutdown() {
      this.running = false;
    }
  }
}
