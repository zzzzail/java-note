package TheArtOfJavaConcurrencyProgramming.Section443;

/**
 * @author zail
 * @since 2018-09-13
 */
public interface ThreadPool<JOB extends Runnable> {
  
  /**
   * 执行一个 job, 该 job 需要实现 Runnable 接口
   *
   * @param job
   */
  void execute(JOB job);
  
  // 关闭线程池
  void shutdown();
  
  /**
   * 增加工作者线程
   *
   * @param num 需要增加的线程数量
   */
  void addWorkers(int num);
  
  /**
   * 减少工作者线程
   *
   * @param num 需要减少的线程数量
   */
  void removeWorkers(int num);
  
  /**
   * 得到正在等待执行的任务数量
   *
   * @return
   */
  int getJobSize();
  
}
