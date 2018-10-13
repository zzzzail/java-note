package com.fsocity.security.core.validate.code;

import com.fsocity.security.core.validate.code.image.ImageCodeGenerator;
import com.fsocity.security.core.validate.code.sms.DefaultSmsCodeSender;
import com.fsocity.security.core.validate.code.sms.SmsCodeGenerator;
import com.fsocity.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zail
 * @since 2018-01-10
 */
@Configuration
public class ValidateCodeBeanConfig {

  /**
   *
   * @return
   * @ConditionalOnMissingBean 当spring容器中没有参数name的bean时, 则使用该bean
   */
  @Bean
  @ConditionalOnMissingBean(name = "imageCodeGenerator")
  public ValidateCodeGenerator imageCodeGenerator() {
    ImageCodeGenerator generator = new ImageCodeGenerator();
    return generator;
  }
  
  @Bean
  @ConditionalOnMissingBean(name = "smsCodeGenerator")
  public ValidateCodeGenerator smsCodeGenerator() {
    SmsCodeGenerator generator = new SmsCodeGenerator();
    return generator;
  }
  
  @Bean
  @ConditionalOnMissingBean(SmsCodeSender.class)
  public SmsCodeSender smsCodeSender() {
    return new DefaultSmsCodeSender();
  }
  
}
