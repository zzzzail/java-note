package com.fsocity.security.code;

import com.fsocity.security.core.validate.code.image.ImageCode;
import com.fsocity.security.core.validate.code.ValidateCodeGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 图形验证码配置
 * 以增量的方式去适应变化: 当原来的代码逻辑满足不了我现有的实现时, 不是去修改原有的代码和全部重写原有的代码,
 * 而是重写原有的代码来实现现有的逻辑.
 * @author zail
 * @since 2018-01-10
 */
// @Component("imageCodeGenerator")
@Slf4j
public class DemoImageCodeGenerator implements ValidateCodeGenerator{
  
  @Override
  public ImageCode generator(ServletWebRequest request) {
    log.info("配置自定义高级的图形验证码");
    return null;
  }
}
