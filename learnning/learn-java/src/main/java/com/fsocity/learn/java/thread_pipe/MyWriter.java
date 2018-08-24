package com.fsocity.learn.java.thread_pipe;

import java.io.PipedOutputStream;
import java.io.PrintStream;

/**
 * @author zail
 * @since 2018-07-22
 */
public class MyWriter extends Thread {
  
  private PipedOutputStream outputStream;
  
  private String messages[] = {"Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
    "Sunday"};
  
  public MyWriter(PipedOutputStream outputStream) {
    this.outputStream = outputStream;
  }
  
  @Override
  public void run() {
    PrintStream p = new PrintStream(outputStream);
    for (int i = 0; i< messages.length; i++) {
      p.println(messages[i]);
      p.flush();
      System.out.println("Write: " + messages[i]);
    }
    p.close();
    p = null;
  }
}
