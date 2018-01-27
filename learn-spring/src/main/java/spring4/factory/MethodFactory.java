package spring4.factory;

/**
 * 工厂方法
 * 优点:
 *   * 屏蔽了客户端实例化对象的细节, 用户只需要关系自己使用的工厂即可.
 *   * 加入新的产品(图片读取器), 无需更改现有代码, 提供系统可扩展性, 符合开闭原则
 *   * 具备多态性, 又被称为多态工厂类
 * 缺点:
 *   * 每次都需要编写对象和对象工厂类, 随着业务的发展, 一定程度上增加了系统的复杂度
 * @author zail
 * @since 2018-01-26
 */
public class MethodFactory {
  
  public static void main(String[] args) {
    ImageReaderFactory jpg = new JpgImageReaderFactory();
    ImageReader jpgReader = jpg.create();
    jpgReader.read();
    
    ImageReaderFactory png = new PngImageReaderFactory();
    ImageReader pngReader = png.create();
    pngReader.read();
  }
}
