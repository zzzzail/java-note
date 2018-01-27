package spring4.factory;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author zail
 * @since 2018-01-26
 */
public class JpgImageReader implements ImageReader {
  
  public JpgImageReader() {
    System.out.println("创建jpg读取器");
  }
  
  @Override
  public void read() {
    System.out.println("读取jpg文件");
  }
}
