package com.fsocity.security.core.validate.code;

import com.fsocity.security.core.constant.UriConstant;
import com.fsocity.security.core.properties.SecurityProperties;
import com.fsocity.security.core.validate.code.image.ImageCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义验证码校验过滤器
 *
 * @author zail
 * @since 2018-01-09
 */
@Slf4j
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {
  
  private AuthenticationFailureHandler authenticationFailureHandler;
  
  private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
  
  // 存储所有配置的请求
  private Set<String> urls = new HashSet<>();
  
  private SecurityProperties securityProperties;
  
  private PathMatcher pathMatcher = new AntPathMatcher();
  
  @Override
  public void afterPropertiesSet() throws ServletException {
    super.afterPropertiesSet();
    String[] configUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(securityProperties.getCode().getImage().getUrl(), ",");
    for (String url: configUrls) {
      urls.add(url);
    }
    
    urls.add("/authentication/form");
  }
  
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
  
    /**
     * 判断 url 匹配
     */
    boolean action = false;
    for (String url : urls) {
      if (pathMatcher.match(url, request.getRequestURI())) action = true;
    }
    
    if (action && StringUtils.equalsIgnoreCase(request.getMethod(), "post")) {
      try {
        validate(new ServletWebRequest(request));
      }
      catch (ValidateCodeException e) {
        // 捕获到异常使用异常处理器处理
        authenticationFailureHandler.onAuthenticationFailure(request, response, e);
        return;
      }
    }
    
    // 调用后面的过滤器
    filterChain.doFilter(request, response);
  }
  
  /**
   * 验证码校验
   *
   * @param request
   */
  private void validate(ServletWebRequest request) throws ServletRequestBindingException {
    String type = StringUtils.substringAfter(request.getRequest().getRequestURI(), UriConstant.VALIDATE_CODE_URI_PREFIX);
    
    ImageCode codeInSession = (ImageCode) sessionStrategy.getAttribute(request, ValidateCodeProcessor.SESSION_KEY_PREFIX + type);
    String codeInRequest = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), "imageCode");
    
    log.info("请求验证码为: {}, session保存的验证码为: {}", codeInRequest, codeInSession.getCode());
    
    // 判断是否为空
    if (StringUtils.isBlank(codeInRequest)) throw new ValidateCodeException("验证码的值不能为为空");
    // 判断session中是否有该有验证码
    if (codeInSession == null) throw new ValidateCodeException("验证码不存在");
    // 判断是否过期
    if (codeInSession.isExpired()) {
      sessionStrategy.removeAttribute(request, ValidateCodeProcessor.SESSION_KEY_PREFIX + type);
      throw new ValidateCodeException("验证码已过期");
    }
    // 判断是否匹配
    if (!StringUtils.equalsIgnoreCase(codeInSession.getCode(), codeInRequest)) {
      throw new ValidateCodeException("验证码不匹配");
    }
    
    sessionStrategy.removeAttribute(request, ValidateCodeProcessor.SESSION_KEY_PREFIX + type);
    
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
  
  public Set<String> getUrls() {
    return urls;
  }
  
  public void setUrls(Set<String> urls) {
    this.urls = urls;
  }
  
  public SecurityProperties getSecurityProperties() {
    return securityProperties;
  }
  
  public void setSecurityProperties(SecurityProperties securityProperties) {
    this.securityProperties = securityProperties;
  }
  
  public PathMatcher getPathMatcher() {
    return pathMatcher;
  }
  
  public void setPathMatcher(PathMatcher pathMatcher) {
    this.pathMatcher = pathMatcher;
  }
}
