package com.fsocity.security.core.properties;

import lombok.Data;

/**
 * @author zail
 * @since 2017-12-28
 */
public enum  LoginType {
  
  /**
   * json 格式返回
   */
  JSON,
  
  /**
   * 跳转到登录页面
   */
  REDIRECT

}
