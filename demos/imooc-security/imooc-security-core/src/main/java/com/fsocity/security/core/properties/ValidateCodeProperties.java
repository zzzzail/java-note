package com.fsocity.security.core.properties;

import lombok.Data;

/**
 * @author zail
 * @since 2018-01-10
 */
@Data
public class ValidateCodeProperties {
  
  private ImageCodeProperties image = new ImageCodeProperties();
  
  private SmsCodeProperties sms = new SmsCodeProperties();
  
}
