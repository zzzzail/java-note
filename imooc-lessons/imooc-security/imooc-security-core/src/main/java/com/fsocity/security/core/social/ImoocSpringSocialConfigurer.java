package com.fsocity.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @author zail
 * @since 2018-01-20
 */
public class ImoocSpringSocialConfigurer extends SpringSocialConfigurer {
  
  private String filterProcessUrl;
  
  public ImoocSpringSocialConfigurer(String filterProcessUrl) {
    this.filterProcessUrl = filterProcessUrl;
  
  }
  
  @Override
  protected <T> T postProcess(T object) {
    SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
    filter.setFilterProcessesUrl(filterProcessUrl);
    return (T) filter;
  }
}
