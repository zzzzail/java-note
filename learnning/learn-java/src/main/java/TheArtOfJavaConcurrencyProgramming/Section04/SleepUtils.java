package TheArtOfJavaConcurrencyProgramming.Section04;

import java.util.concurrent.TimeUnit;

/**
 * @author zail
 * @since 2018-09-06
 */
public class SleepUtils {
  
  public static final void sleep(long seconds) {
    try {
      TimeUnit.SECONDS.sleep(seconds);
    }
    catch (InterruptedException e) {
    }
  }
}
