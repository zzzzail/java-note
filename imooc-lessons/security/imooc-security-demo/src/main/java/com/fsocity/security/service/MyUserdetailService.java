package com.fsocity.security.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

/**
 * @author zail
 * @since 2017-12-27
 */
@Component
@Slf4j
public class MyUserdetailService implements UserDetailsService, SocialUserDetailsService {
  
  @Autowired
  private PasswordEncoder passwordEncoder;
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.info("登录用户名: {}", username);
    
    // 处理用户信息获取逻辑: 根据用户名查找用户信息
    // 根据查找到的用户信息判断用户是否被冻结
    String password = passwordEncoder.encode("123456");
    
    log.info("用户的密码是: {}", password);
    
    UserDetails userDetails = new User(
      username,
      password,
      true, // 账号是否可用
      true, // 账号是否过期
      true, // 是否需要更改密码
      true, // 账号是否锁定
      AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    
    return userDetails;
  }
  
  @Override
  public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
    log.info("登录用户id: {}", userId);
    
    // 处理用户信息获取逻辑: 根据用户名查找用户信息
    // 根据查找到的用户信息判断用户是否被冻结
    String password = passwordEncoder.encode("123456");
    
    log.info("用户的密码是: {}", password);
    
    SocialUserDetails userDetails = new SocialUser(userId, password,
      true,
      true,
      true,
      true,
      AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    
    return userDetails;
  }
}
