package TheArtOfJavaConcurrencyProgramming.Section05;

import TheArtOfJavaConcurrencyProgramming.Section04.SleepUtils;

/**
 * @author zail
 * @since 2018-09-07
 */
public class DaemonDemo {
  
  public static void main(String[] args) {
    Thread thread = new Thread(new DaemonRunner(), "DaemonThread");
    thread.setDaemon(true);
    thread.start();
  }
  
  static class DaemonRunner implements Runnable {
    @Override
    public void run() {
      try {
        SleepUtils.sleep(10);
      }
      finally {
        System.out.println("DaemonThread finally run.");
      }
    }
  }

}
