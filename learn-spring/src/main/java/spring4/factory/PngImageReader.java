package spring4.factory;

/**
 * @author zail
 * @since 2018-01-26
 */
public class PngImageReader implements ImageReader {
  
  public PngImageReader() {
    System.out.println("创建png读取器");
  }
  
  @Override
  public void read() {
    System.out.println("读取png文件");
  }
}
