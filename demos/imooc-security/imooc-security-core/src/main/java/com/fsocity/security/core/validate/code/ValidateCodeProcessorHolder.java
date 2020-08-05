package com.fsocity.security.core.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 查找不同的验证码处理器
 * @author zail
 * @since 2018-01-16
 */
@Component
public class ValidateCodeProcessorHolder {
  
  @Autowired
  private Map<String, ValidateCodeProcessor> validateCodeProcessors;
  
  public ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType type) {
    return findValidateCodeProcessor(type.toString().toLowerCase());
  }
  
  public ValidateCodeProcessor findValidateCodeProcessor(String type) {
    String name = type.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
    ValidateCodeProcessor processor = validateCodeProcessors.get(name);
    if (processor == null) {
      throw new ValidateCodeException("验证码处理器" + name + "不存在");
    }
    return processor;
  }
  
}
