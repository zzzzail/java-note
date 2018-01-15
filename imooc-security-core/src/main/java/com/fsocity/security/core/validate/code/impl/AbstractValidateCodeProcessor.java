package com.fsocity.security.core.validate.code.impl;

import com.fsocity.security.core.constant.UriConstant;
import com.fsocity.security.core.validate.code.ValidateCodeGenerator;
import com.fsocity.security.core.validate.code.ValidateCodeProcessor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * @author zail
 * @since 2018-01-11
 */
@Slf4j
public abstract class AbstractValidateCodeProcessor<C> implements ValidateCodeProcessor {
  
  /**
   * 操作 session 工具类
   */
  private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
  
  /**
   * 系统中所有的 {@link ValidateCodeGenerator} 接口实现
   */
  @Autowired
  private Map<String, ValidateCodeGenerator> validateCodeGenerators;
  
  @Override
  public void create(ServletWebRequest request) throws Exception {
    // 1. 生成
    C validateCode = generate(request);
    // 2. 保存
    save(request, validateCode);
    // 3. 发送
    send(request, validateCode);
  }
  
  private C generate(ServletWebRequest request) {
    String type = getProcessorType(request);
    ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(type + "CodeGenerator");
    return (C) validateCodeGenerator.generator(request);
  }
  
  /**
   * 保存校验码
   * @param request
   * @param validateCode
   */
  private void save(ServletWebRequest request, C validateCode) {
    log.info("存session中的名字是 {}", getProcessorType(request));
    sessionStrategy.setAttribute(request,
      SESSION_KEY_PREFIX + getProcessorType(request), validateCode);
  }
  
  /**
   * 发送校验码, 由子类实现
   * @param request
   * @param validateCode
   */
  protected abstract void send(ServletWebRequest request, C validateCode) throws Exception;
  
  /**
   * 根据请求的url获取检验码的类型
   * @param request
   * @return
   */
  private String getProcessorType(ServletWebRequest request) {
    return StringUtils.substringAfter(request.getRequest().getRequestURI(),
      UriConstant.VALIDATE_CODE_URI_PREFIX);
  }
}
