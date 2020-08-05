package com.fsocity.learn.java.thread_pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author zail
 * @since 2018-07-22
 */
public class PipeThread {
  
  public static void main(String[] args) {
    PipeThread thisPipe = new PipeThread();
    thisPipe.process();
  }
  
  public void process() {
    PipedInputStream inputStream;
    PipedOutputStream outputStream;
    try {
      outputStream = new PipedOutputStream();
      inputStream = new PipedInputStream(outputStream);
      new MyWriter(outputStream).start();
      new MyReader(inputStream).start();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
  
}
