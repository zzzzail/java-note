package com.fsocity.security.core.properties;

import lombok.Data;

/**
 * @author zail
 * @since 2018-01-10
 */
@Data
public class ImageCodeProperties extends SmsCodeProperties {
  
  // 图片宽度
  private int width = 67;
  
  // 图片高度
  private int height = 23;
  
  private String url = "";
  
}
