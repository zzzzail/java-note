package com.fsocity.security.core.validate.code;

import com.fsocity.security.core.properties.SecurityConstants;
import com.fsocity.security.core.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 验证码校验过滤器, 根据不同的请求使用不同的过滤器
 * @author zail
 * @since 2018-01-09
 */
@Slf4j
@Component
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {
  
  /**
   * 验证码校验失败处理器
   */
  @Autowired
  private AuthenticationFailureHandler authenticationFailureHandler;
  
  /**
   * 系统配置信息
   */
  @Autowired
  private SecurityProperties securityProperties;
  
  /**
   * 系统中的校验码处理器
   */
  @Autowired
  private ValidateCodeProcessorHolder validateCodeProcessorHolder;
  
  private Map<String, ValidateCodeType> urlMap = new HashMap<>();
  
  private PathMatcher pathMatcher = new AntPathMatcher();
  
  /**
   * 提前设置好 urlMap
   * @throws ServletException
   */
  @Override
  public void afterPropertiesSet() throws ServletException {
    super.afterPropertiesSet();
    
    urlMap.put(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM, ValidateCodeType.IMAGE);
    addUrlToMap(securityProperties.getCode().getImage().getUrl(), ValidateCodeType.IMAGE);
    
    urlMap.put(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE, ValidateCodeType.SMS);
    addUrlToMap(securityProperties.getCode().getSms().getUrl(), ValidateCodeType.SMS);
  }
  
  /**
   * 将系统中配置的需要校验验证码的URL根据校验的类型放入map中
   * @param urlString
   * @param type
   */
  protected void addUrlToMap(String urlString, ValidateCodeType type) {
    if (StringUtils.isNotBlank(urlString)) {
      String[] urls = StringUtils.splitByWholeSeparatorPreserveAllTokens(urlString, ",");
      for (String url: urls) {
        urlMap.put(url, type);
      }
    }
  }
  
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
    throws ServletException, IOException {
  
    log.info("urlMap = {}", urlMap);
    
    ValidateCodeType type = getValidateCodeType(request);
    
    if (type != null) {
      log.info("校验请求 {} 中的验证码, 验证码类型为: {}", request.getRequestURI(), type);
  
      try {
        validateCodeProcessorHolder
          .findValidateCodeProcessor(type)
          .validate(new ServletWebRequest(request, response));
        log.info("验证码校验通过");
      }
      catch (ValidateCodeException exception) {
        authenticationFailureHandler.onAuthenticationFailure(request, response, exception);
        return;
      }
    }
    
    // 调用后面的过滤器
    filterChain.doFilter(request, response);
  }
  
  /**
   * 获取校验码的类型, 如果当前请求不需要校验则返回 null
   * @param request
   * @return
   */
  private ValidateCodeType getValidateCodeType(HttpServletRequest request) {
    ValidateCodeType result = null;
    if (!StringUtils.equalsIgnoreCase(request.getMethod(), "get")) {
      Set<String> urls = urlMap.keySet();
      for (String url: urls) {
        if (pathMatcher.match(url, request.getRequestURI())) {
          result = urlMap.get(url);
        }
      }
    }
    return result;
  }
}
