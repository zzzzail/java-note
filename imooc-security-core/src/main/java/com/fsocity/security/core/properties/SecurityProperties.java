package com.fsocity.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zail
 * @since 2017-12-28
 */
@ConfigurationProperties(prefix = "imooc.security")
public class SecurityProperties {

  private BrowserProperties browser = new BrowserProperties();
  
  public BrowserProperties getBrowser() {
    return browser;
  }
  
  public void setBrowser(BrowserProperties browser) {
    this.browser = browser;
  }
}
