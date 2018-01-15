package com.fsocity.security.core.authentication.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author zail
 * @since 2018-01-15
 */
public class SmsCodeAuthenticationProvider implements AuthenticationProvider {
  
  private UserDetailsService userDetailsService;
  
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    // 使用 UserDetailService 获取用户信息
    SmsCodeAuthenticationToken authenticationToken = (SmsCodeAuthenticationToken) authentication;
    UserDetails userDetails = userDetailsService.loadUserByUsername(
      String.valueOf(authenticationToken.getPrincipal()));
    
    if (userDetails == null)
      throw new InternalAuthenticationServiceException("无法获取用户信息.");
  
    // 重新组装一个已认证的 SmsCodeAuthenticationToken
    SmsCodeAuthenticationToken authenticationResult = new SmsCodeAuthenticationToken(
      userDetails, userDetails.getAuthorities());
  
    authenticationResult.setDetails(authenticationToken.getDetails());
    
    return authenticationResult;
  }
  
  /**
   * 判断传进来的类是否是 SmsCodeAuthenticationToken 类型的
   * @param authentication
   * @return
   */
  @Override
  public boolean supports(Class<?> authentication) {
    return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
  }
  
  public UserDetailsService getUserDetailsService() {
    return userDetailsService;
  }
  
  public void setUserDetailsService(UserDetailsService userDetailsService) {
    this.userDetailsService = userDetailsService;
  }
}
