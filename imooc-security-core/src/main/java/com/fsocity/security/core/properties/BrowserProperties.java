package com.fsocity.security.core.properties;

import lombok.Data;

/**
 * @author zail
 * @since 2017-12-28
 */
public class BrowserProperties {
  
  private String loginPage = "/signin.html";
  
  public String getLoginPage() {
    return loginPage;
  }
  
  public void setLoginPage(String loginPage) {
    this.loginPage = loginPage;
  }
}
