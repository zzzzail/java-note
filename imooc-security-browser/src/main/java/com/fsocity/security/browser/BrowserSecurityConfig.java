package com.fsocity.security.browser;

import com.fsocity.security.browser.authentication.ImoocAuthenticationSuccessHandler;
import com.fsocity.security.core.properties.SecurityProperties;
import com.fsocity.security.core.validate.code.ValidateCodeFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @author zail
 * @since 2017-12-26
 */
@Configuration
@Slf4j
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
  
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
  
  @Bean
  public PersistentTokenRepository persistentTokenRepository() {
    log.info("配置持久化token仓库.");
    JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
    // jdbcTokenRepository.setCreateTableOnStartup(true);
    jdbcTokenRepository.setDataSource(dataSource);
    return jdbcTokenRepository;
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
  
    String loginPage = securityProperties.getBrowser().getLoginPage();
    
    ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
    validateCodeFilter.setAuthenticationFailureHandler(imoocAuthenticationFailureHandler);
    validateCodeFilter.setSecurityProperties(securityProperties);
    validateCodeFilter.afterPropertiesSet();
    
    http
      // 把过滤器加到用户名密码校验过滤器的前面
      .addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
      
      .formLogin()
      .loginPage("/authentication/require") // 自定义登录页面
      .loginProcessingUrl("/authentication/form") // 自定义登录提交URL
      .successHandler(imoocAuthenticationSuccessHandler) // 配置自定义的认证成功处理器
      .failureHandler(imoocAuthenticationFailureHandler) // 配置自定义的认证失败处理器
      .and()
      
      // 记住我功能设置
      .rememberMe()
      .tokenRepository(persistentTokenRepository())
      .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
      .userDetailsService(userDetailsService)
      .and()
      
      .authorizeRequests()
      .antMatchers("/authentication/*", loginPage, "/code/*")
      .permitAll() // 该路由不需要身份认证
      
      .anyRequest()
      .authenticated()
      
      .and()
      .csrf().disable();
    
  }
}
