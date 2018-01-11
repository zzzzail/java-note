package com.fsocity.security.core.validate.code.sms;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zail
 * @since 2018-01-11
 */
@Slf4j
public class DefaultSmsCodeSender implements SmsCodeSender {
  
  @Override
  public void send(String mobile, String code) {
    log.info("向手机号 {} 发送 {} 验证码.", mobile, code);
  }
  
}
