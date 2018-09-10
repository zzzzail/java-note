package TheArtOfJavaConcurrencyProgramming.Section04;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * java 是天生的多线程语言
 *
 * @author zail
 * @since 2018-09-06
 */
public class MultiThread {
  
  /* 打印如下信息:
  
  [5] Monitor Ctrl-Break
  [4] Signal Dispatcher    分发处理, 负责发送给 JVM 信号的线程
  [3] Finalizer            调用对象 finalize 方法的线程
  [2] Reference Handler    清除 reference 的线程
  [1] main                 主线程
  
   */
  public static void main(String[] args) {
    // 获取 java 线程管理 MXBean
    ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
    // 获取线程和线程堆栈的信息
    ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
    // 遍历线程信息, 打印线程的 ID 和名称
    for (ThreadInfo threadInfo : threadInfos) {
      System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
    }
  }
  
}
