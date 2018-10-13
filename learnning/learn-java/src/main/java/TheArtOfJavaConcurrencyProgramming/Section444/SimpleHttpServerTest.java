package TheArtOfJavaConcurrencyProgramming.Section444;

import java.io.IOException;

/**
 * @author zail
 * @since 2018-09-13
 */
public class SimpleHttpServerTest {
  
  public static void main(String[] args) throws IOException {
    SimpleHttpServer.setBasePath("/Users/zail/t");
    SimpleHttpServer.setPort(9091);
    SimpleHttpServer.start();
  }
  
}
