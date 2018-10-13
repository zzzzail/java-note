package com.fsocity.security.core.properties;

import lombok.Data;

/**
 * @author zail
 * @since 2018-01-11
 */
@Data
public class SmsCodeProperties {
  
  // 字符串长度
  private int length = 4;
  
  // 多长时间之后过期, 单位秒
  private int expireIn = 60;
  
  // 需要过滤的url
  private String url = "";
  
}
