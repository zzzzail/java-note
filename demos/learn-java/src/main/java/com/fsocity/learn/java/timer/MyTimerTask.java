package com.fsocity.learn.java.timer;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * @author zail
 * @since 2018-02-02
 */
@Data
public class MyTimerTask extends TimerTask {
  
  private String name;
  
  public void run() {
    Date now = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println("Current exec name is: " + name);
    System.out.println("Cerrnet exec time is " + simpleDateFormat.format(now));
  }
}
