package TheArtOfJavaConcurrencyProgramming.Section05;

import TheArtOfJavaConcurrencyProgramming.Section04.SleepUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author zail
 * @since 2018-09-10
 */
public class Deprecated {
  
  public static void main(String[] args) throws Exception {
    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    Thread printThread = new Thread(new Runner(), "PrintThread");
    printThread.setDaemon(true);
    printThread.start();
    TimeUnit.SECONDS.sleep(3);
    // 将 PrintThread 进行暂停
    printThread.suspend();
    System.out.println("main suspend PrintThread at " + dateFormat.format(new Date()));
    TimeUnit.SECONDS.sleep(3);
    
    // 将 PrintThread 进行恢复
    printThread.resume();
    System.out.println("main resume PrintThread at " + dateFormat.format(new Date()));
    TimeUnit.SECONDS.sleep(3);
    
    // 将 PrintThread 进行终止
    printThread.stop();
    System.out.println("main stop PrintThread at " + dateFormat.format(new Date()));
    TimeUnit.SECONDS.sleep(3);
  }
  
  static class Runner implements Runnable {
    @Override
    public void run() {
      DateFormat format = new SimpleDateFormat("HH:mm:ss");
      while (true) {
        System.out.println(Thread.currentThread().getName() + " Run at " +
          format.format(new Date()));
        SleepUtils.sleep(1);
      }
    }
  }
  
}
