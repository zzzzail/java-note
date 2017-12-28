package com.fsocity.security.browser.config;

import com.fsocity.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zail
 * @since 2017-12-26
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
  
  @Autowired
  private SecurityProperties securityProperties;
  
  // 处理密码的加密解密
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    
    String loginPage = securityProperties.getBrowser().getLoginPage();
    
    http
      .formLogin()
      .loginPage("/authentication/require") // 自定义登录页面
      .loginProcessingUrl("/authentication/form")
      .and()
      .authorizeRequests()
      .antMatchers("/authentication/require", loginPage).permitAll() // 该路由不需要身份认证
      .anyRequest()
      .authenticated()
      
      .and()
      .csrf().disable();
    
  }
}
