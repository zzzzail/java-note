package com.fsocity.security.core.validate.code;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义验证码校验过滤器
 * @author zail
 * @since 2018-01-09
 */
public class ValidateCodeFilter extends OncePerRequestFilter {
  
  private AuthenticationFailureHandler authenticationFailureHandler;
  
  private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
  
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    
    if (StringUtils.equals("/authentication/form", request.getRequestURI())
      && StringUtils.equalsIgnoreCase(request.getMethod(), "POST")) {
      try {
        validate(new ServletWebRequest(request));
      }
      catch (ValidateCodeException e) {
        // 捕获到异常使用异常处理器处理
        authenticationFailureHandler.onAuthenticationFailure(request, response, e);
        return;
      }
    }
    else {
      // 调用后面的过滤器
      filterChain.doFilter(request, response);
    }
    
  }
  
  /**
   * 验证码校验
   * @param servletWebRequest
   */
  private void validate(ServletWebRequest servletWebRequest) throws ServletRequestBindingException {
    
    ImageCode codeInSession = (ImageCode) sessionStrategy.getAttribute(servletWebRequest, ValidateCodeFilter.ALREADY_FILTERED_SUFFIX);
    
    String codeInRequest = ServletRequestUtils.getRequiredStringParameter(servletWebRequest.getRequest(), "imageCode");
    
    // 判断是否为空
    if (StringUtils.isBlank(codeInRequest)) throw new ValidateCodeException("验证码的值不能为为空");
    // 判断session中是否有该有验证码
    if (codeInSession == null) throw new ValidateCodeException("验证码不存在");
    // 判断是否过期
    if (codeInSession.isExpired()) {
      sessionStrategy.removeAttribute(servletWebRequest, ValidateCodeFilter.ALREADY_FILTERED_SUFFIX);
      throw new ValidateCodeException("验证码已过期");
    }
    // 判断是否匹配
    if (!StringUtils.equalsIgnoreCase(codeInSession.getCode(), codeInRequest)) {
      throw new ValidateCodeException("验证码不匹配");
    }
    
    sessionStrategy.removeAttribute(servletWebRequest, ValidateCodeFilter.ALREADY_FILTERED_SUFFIX);
    
  }
  
  public AuthenticationFailureHandler getAuthenticationFailureHandler() {
    return authenticationFailureHandler;
  }
  
  public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
    this.authenticationFailureHandler = authenticationFailureHandler;
  }
  
  public SessionStrategy getSessionStrategy() {
    return sessionStrategy;
  }
  
  public void setSessionStrategy(SessionStrategy sessionStrategy) {
    this.sessionStrategy = sessionStrategy;
  }
}
