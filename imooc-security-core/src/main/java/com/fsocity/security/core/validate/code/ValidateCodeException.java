package com.fsocity.security.core.validate.code;


import org.springframework.security.core.AuthenticationException;

/**
 * 验证码错误异常
 * @author zail
 * @since 2018-01-09
 */
public class ValidateCodeException extends AuthenticationException {
  
  private static final long serialVersionUID = 1732044216710848905L;
  
  public ValidateCodeException(String msg, Throwable t) {
    super(msg, t);
  }
  
  public ValidateCodeException(String msg) {
    super(msg);
  }
  
}
