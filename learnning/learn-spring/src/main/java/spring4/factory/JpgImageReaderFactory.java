package spring4.factory;

/**
 * @author zail
 * @since 2018-01-26
 */
public class JpgImageReaderFactory implements ImageReaderFactory {
  
  @Override
  public ImageReader create() {
    System.out.println("实例化jpg文件工厂类");
    return new JpgImageReader();
  }
}
