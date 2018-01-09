package com.fsocity.security.core.validate.code;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * 图形验证码
 * @author zail
 * @since 2018-01-09
 */
@Data
public class ImageCode {
  
  /**
   * 实际图片
   */
  private BufferedImage image;
  
  /**
   * 生成的验证码
   */
  private String code;
  
  /**
   * 过期时间
   */
  private LocalDateTime expireTime;
  
  public ImageCode() {
  }
  
  public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
    this.image = image;
    this.code = code;
    this.expireTime = expireTime;
  }
  
  /**
   * @param image
   * @param code
   * @param expireIn 设置多少秒之后过期
   */
  public ImageCode(BufferedImage image, String code, int expireIn) {
    this.image = image;
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
}
