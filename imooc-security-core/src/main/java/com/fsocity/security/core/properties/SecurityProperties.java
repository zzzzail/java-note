package com.fsocity.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zail
 * @since 2017-12-28
 */
@ConfigurationProperties(prefix = "imooc.security")
@Data
public class SecurityProperties {
  
  /**
   * 浏览器配置
   */
  private BrowserProperties browser = new BrowserProperties();
  
  /**
   * 验证码配置
   */
  private ValidateCodeProperties code = new ValidateCodeProperties();
  
}
