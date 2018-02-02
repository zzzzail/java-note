package com.fsocity.learn.java.timer;

/**
 * @author zail
 * @since 2018-02-02
 */
public class TestMyTimerTask {
  
  public static void main(String[] args) {
    MyTimerTask myTimerTask = new MyTimerTask();
    myTimerTask.setName("Test");
    myTimerTask.run();
  }
}
