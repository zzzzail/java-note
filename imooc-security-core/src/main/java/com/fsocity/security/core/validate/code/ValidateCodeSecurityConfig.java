package com.fsocity.security.core.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

/**
 * @author zail
 * @since 2018-01-16
 */
@Configuration("validateCodeSecurityConfig")
public class ValidateCodeSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
  
  @Autowired
  private ValidateCodeFilter validateCodeFilter;
  
  @Override
  public void configure(HttpSecurity http) throws Exception {
    http
      .addFilterBefore(validateCodeFilter, AbstractPreAuthenticatedProcessingFilter.class);
  }
}
