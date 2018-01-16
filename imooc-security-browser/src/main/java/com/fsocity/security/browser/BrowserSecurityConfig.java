package com.fsocity.security.browser;

import com.fsocity.security.core.authentication.AbstractChannelSecurityConfig;
import com.fsocity.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.fsocity.security.core.properties.SecurityConstants;
import com.fsocity.security.core.properties.SecurityProperties;
import com.fsocity.security.core.validate.code.ValidateCodeSecurityConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @author zail
 * @since 2017-12-26
 */
@Configuration
@Slf4j
public class BrowserSecurityConfig extends AbstractChannelSecurityConfig {
  
  @Autowired
  private SecurityProperties securityProperties;
  
  @Autowired
  private AuthenticationSuccessHandler imoocAuthenticationSuccessHandler;
  
  @Autowired
  private AuthenticationFailureHandler imoocAuthenticationFailureHandler;
  
  // 处理密码的加密解密
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
  @Autowired
  private DataSource dataSource;
  
  @Autowired
  private UserDetailsService userDetailsService;
  
  @Autowired
  private ValidateCodeSecurityConfig validateCodeSecurityConfig;
  
  @Autowired
  private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
  
  @Bean
  public PersistentTokenRepository persistentTokenRepository() {
    JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
    // jdbcTokenRepository.setCreateTableOnStartup(true);
    jdbcTokenRepository.setDataSource(dataSource);
    return jdbcTokenRepository;
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    
    // 应用账号密码登录配置
    applyPasswordAuthenticationConfig(http);
    
    http
      .apply(validateCodeSecurityConfig)
      .and()
      
      .apply(smsCodeAuthenticationSecurityConfig)
      .and()
      
      // 记住我功能设置
      .rememberMe()
      .tokenRepository(persistentTokenRepository())
      .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
      .userDetailsService(userDetailsService)
      .and()
  
      // 该路由不需要身份认证
      .authorizeRequests()
      .antMatchers(
        SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
        securityProperties.getBrowser().getLoginPage(),
        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*")
      .permitAll()
      .anyRequest()
      .authenticated()
      
      .and()
      .csrf().disable();
  }
}
