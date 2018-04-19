package com.fsocity.security.core.validate.code.sms;

import com.fsocity.security.core.properties.SecurityProperties;
import com.fsocity.security.core.validate.code.ValidateCode;
import com.fsocity.security.core.validate.code.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 短信验证码生成器
 *
 * @author zail
 * @since 2018-01-11
 */
@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {
  
  @Autowired
  private SecurityProperties securityProperties;
  
  @Override
  public ValidateCode generator(ServletWebRequest request) {
    String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
    return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
  }
}
