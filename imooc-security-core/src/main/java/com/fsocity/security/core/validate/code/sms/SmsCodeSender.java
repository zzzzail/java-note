package com.fsocity.security.core.validate.code.sms;

/**
 * @author zail
 * @since 2018-01-11
 */
public interface SmsCodeSender {
  
  /**
   * 发送手机验证码
   * @param mobile
   * @param code
   */
  void send(String mobile, String code);
  
}
