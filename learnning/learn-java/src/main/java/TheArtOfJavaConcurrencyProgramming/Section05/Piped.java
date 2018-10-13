package TheArtOfJavaConcurrencyProgramming.Section05;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.sql.SQLOutput;

/**
 * @author zail
 * @since 2018-09-12
 */
public class Piped {
  
  public static void main(String[] args) throws IOException {
    PipedWriter out = new PipedWriter();
    PipedReader in = new PipedReader();
    // 将输入流与输出流进行链接, 否则在使用时将会抛出 IOException.
    out.connect(in);
    
    Print print = new Print(in);
    Thread thread = new Thread(print, "PrintThread");
    thread.start();
    
    int receive = 0;
    try {
      while ((receive = System.in.read()) != -1) {
        out.write(receive);
      }
    }
    catch (Exception e) {
      out.close();
    }
  }
  
  static class Print implements Runnable {
    private PipedReader in;
    
    public Print(PipedReader in) {
      this.in = in;
    }
    
    @Override
    public void run() {
      int receive = 0;
      try {
        while ((receive = in.read()) != -1) {
          System.out.print((char) receive);
        }
      }
      catch (IOException e) {
      }
    }
  }

}
