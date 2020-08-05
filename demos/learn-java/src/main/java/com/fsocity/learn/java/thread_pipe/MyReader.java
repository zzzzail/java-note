package com.fsocity.learn.java.thread_pipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;

/**
 * @author zail
 * @since 2018-07-22
 */
public class MyReader extends Thread {
  
  private PipedInputStream inputStream;
  
  public MyReader(PipedInputStream inputStream) {
    this.inputStream = inputStream;
  }
  
  @Override
  public void run() {
    String line;
    boolean reading = true;
    BufferedReader d = new BufferedReader(new InputStreamReader(inputStream));
    
    while (reading && d != null) {
      try {
        line = d.readLine();
        if (line != null) System.out.println("Read: " + line);
        else reading = false;
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
