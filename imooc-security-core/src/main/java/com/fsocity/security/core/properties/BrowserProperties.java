package com.fsocity.security.core.properties;

import lombok.Data;

/**
 * @author zail
 * @since 2017-12-28
 */
@Data
public class BrowserProperties {
  
  private String loginPage = "/signin.html";
  
  private LoginType loginType = LoginType.JSON;
  
  /**
   * token 过期时间, 默认一小时
   */
  private int rememberMeSeconds = 3600;
  
}
