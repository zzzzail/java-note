package com.fsocity.security.browser.config;

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
  
  // 处理密码的加密解密
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    
    http
      .formLogin()
      .and()
      .authorizeRequests()
      .anyRequest()
      .authenticated();
    
  }
}
