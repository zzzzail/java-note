package com.fsocity.security.core.validate.code.image;

import com.fsocity.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;

/**
 * @author zail
 * @since 2018-01-11
 */
@Component("imageCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {
  
  @Override
  protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
    // 写入到响应输出流中
    ImageIO.write(imageCode.getImage(), "JPEG",
      request.getResponse().getOutputStream());
  }
  
}
