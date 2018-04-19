package com.fsocity.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 处理验证码的所有生成流程
 * 生成 -> 保存 -> 发送
 * @author zail
 * @since 2018-01-11
 */
public interface ValidateCodeProcessor {
  
  /**
   * 验证码放入session时的前缀
   */
  String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";
  
  /**
   * 创建验证码
   * @param request
   * @throws Exception
   */
  void create(ServletWebRequest request) throws Exception;
  
  /**
   * 校验验证码
   * @param request
   * @return
   */
  void validate(ServletWebRequest request);

}
