package com.fsocity.security.core.properties;

import lombok.Data;

/**
 * @author zail
 * @since 2017-12-28
 */
public class BrowserProperties {
  
  private String loginPage = "/signin.html";
  
  private LoginType loginType = LoginType.JSON;
  
  public String getLoginPage() {
    return loginPage;
  }
  
  public void setLoginPage(String loginPage) {
    this.loginPage = loginPage;
  }
  
  public LoginType getLoginType() {
    return loginType;
  }
  
  public void setLoginType(LoginType loginType) {
    this.loginType = loginType;
  }
}
