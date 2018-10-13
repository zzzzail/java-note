package com.fsocity.security.core.validate.code;

import com.fsocity.security.core.properties.SecurityConstants;

/**
 * @author zail
 * @since 2018-01-16
 */
public enum ValidateCodeType {
  
  /**
   * 图片验证码
   */
  IMAGE {
    @Override
    public String getParamNameOnValidate() {
      return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
    }
  },
  
  /**
   * 短信验证码
   */
  SMS {
    @Override
    public String getParamNameOnValidate() {
      return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
    }
  }
  
  ;
  
  /**
   * 校验时从请求中获取的参数的名字
   *
   * @return
   */
  public abstract String getParamNameOnValidate();
}
