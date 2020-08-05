package com.fsocity.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码生成接口
 * @author zail
 * @since 2018-01-10
 */
public interface ValidateCodeGenerator {
  
  ValidateCode generator(ServletWebRequest request);

}
