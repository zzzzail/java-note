package com.fsocity.security.browser.support;

import lombok.Data;

/**
 * @author zail
 * @since 2018-01-20
 */
@Data
public class SocialUserInfo {
  
  private String providerId;
  
  private String providerUserId;
  
  private String nickname;
  
  private String headimg;
  
}
