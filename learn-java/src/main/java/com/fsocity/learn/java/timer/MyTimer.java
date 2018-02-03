package com.fsocity.learn.java.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

/**
 * @author zail
 * @since 2018-02-02
 */
public class MyTimer {
  
  public static void main(String[] args) {
    Timer timer = new Timer();
    MyTimerTask myTimerTask = new MyTimerTask();
    myTimerTask.setName("timerTask01");
  
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println(simpleDateFormat.format(calendar.getTime()));
    calendar.add(Calendar.SECOND, 5);
    
    // 设置5秒钟后执行
    // timer.schedule(myTimerTask, calendar.getTime());
  
    /**
     * 过5秒钟后执行一次, 之后没过2秒钟后执行一次
     */
    // myTimerTask.setName("timerTask02");
    // timer.schedule(myTimerTask, calendar.getTime(), 2000);
  
    /**
     * 该task会立即执行, 然后再延迟delay时间执行, 再每隔period时间执行一次
     * delay: 延迟多少秒执行
     */
    // myTimerTask.setName("timerTask03");
    // timer.schedule(myTimerTask, 3000, 2000);
  
    /**
     * 和schedule一样是设置时间段执行, 每隔period时间执行一次
     */
    // myTimerTask.setName("timerTask04");
    // timer.scheduleAtFixedRate(myTimerTask, calendar.getTime(), 2000);
  
    /**
     * 和schedule一样
     * 那区别是什么啊?
     */
    myTimerTask.setName("timerTask05");
    timer.scheduleAtFixedRate(myTimerTask, 3000, 2000);
  }

}
