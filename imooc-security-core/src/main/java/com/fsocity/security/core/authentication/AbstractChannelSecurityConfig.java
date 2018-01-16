package com.fsocity.security.core.authentication;

import com.fsocity.security.core.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * 账号密码登录相关的配置
 * @author zail
 * @since 2018-01-16
 */
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {
  
  @Autowired
  protected AuthenticationSuccessHandler imoocAuthenticationSuccessHandler;
  
  @Autowired
  protected AuthenticationFailureHandler imoocAuthenticationFailureHandler;
  
  protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
    http
      .formLogin()
      
      // 自定义登录页面
      .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
      // 自定义登录提交URL
      .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
  
      // 配置自定义的认证成功处理器
      .successHandler(imoocAuthenticationSuccessHandler)
      // 配置自定义的认证失败处理器
      .failureHandler(imoocAuthenticationFailureHandler);
  }
}
