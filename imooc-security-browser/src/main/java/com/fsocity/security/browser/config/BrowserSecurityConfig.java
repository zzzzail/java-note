package com.fsocity.security.browser.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author zail
 * @since 2017-12-26
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    
    // http
    //   .formLogin()
    //   .and()
    //   .authorizeRequests()
    //   .anyRequest()
    //   .authenticated();
    
  }
}
