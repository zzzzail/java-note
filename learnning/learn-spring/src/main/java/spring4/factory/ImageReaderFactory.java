package spring4.factory;

/**
 * 图片读取工厂接口
 * @author zail
 * @since 2018-01-26
 */
public interface ImageReaderFactory {
  
  ImageReader create();
}
