package com.fsocity.security.core.validate.code;

import java.time.LocalDateTime;

/**
 * 验证码
 * @author zail
 * @since 2018-01-11
 */
public class ValidateCode {
  
  /**
   * 生成的验证码
   */
  private String code;
  
  /**
   * 过期时间
   */
  private LocalDateTime expireTime;
  
  public ValidateCode() {
  }
  
  public ValidateCode(String code, LocalDateTime expireTime) {
    this.code = code;
    this.expireTime = expireTime;
  }
  
  /**
   * @param code
   * @param expireIn 设置多长时间之后过期, 单位秒
   */
  public ValidateCode(String code, int expireIn) {
    this.code = code;
    this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
  }
  
  /**
   * 判断验证码是否过期
   * @return
   */
  public boolean isExpired() {
    // 返回验证码是否在过期之后
    return LocalDateTime.now().isAfter(expireTime);
  }
  
  public String getCode() {
    return code;
  }
  
  public void setCode(String code) {
    this.code = code;
  }
  
  public LocalDateTime getExpireTime() {
    return expireTime;
  }
  
  public void setExpireTime(LocalDateTime expireTime) {
    this.expireTime = expireTime;
  }
}
