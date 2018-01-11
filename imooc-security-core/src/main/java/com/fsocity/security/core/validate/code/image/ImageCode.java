package com.fsocity.security.core.validate.code.image;

import com.fsocity.security.core.validate.code.ValidateCode;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * 图形验证码
 * @author zail
 * @since 2018-01-09
 */
public class ImageCode extends ValidateCode {
  
  /**
   * 实际图片
   */
  private BufferedImage image;
  
  public ImageCode() {
  }
  
  public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
    super(code, expireTime);
    this.image = image;
  }
  
  public ImageCode(BufferedImage image, String code, int expireIn) {
    super(code, expireIn);
    this.image = image;
  }
  
  public BufferedImage getImage() {
    return image;
  }
  
  public void setImage(BufferedImage image) {
    this.image = image;
  }
}
