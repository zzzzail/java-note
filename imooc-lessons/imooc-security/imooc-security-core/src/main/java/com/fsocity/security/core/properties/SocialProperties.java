package com.fsocity.security.core.properties;

import lombok.Data;

/**
 * @author zail
 * @since 2018-01-19
 */
@Data
public class SocialProperties {
  
  /**
   * 过滤器处理的url
   */
  private String filterProcessorUrl = "/auth";
  
  private QQProperties qq = new QQProperties();
  
}
