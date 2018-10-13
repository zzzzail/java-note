package com.fsocity.security.browser;

import com.fsocity.security.browser.support.SimpleResponse;
import com.fsocity.security.browser.support.SocialUserInfo;
import com.fsocity.security.core.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zail
 * @since 2017-12-27
 */
@RestController
@Slf4j
public class BrowserSecurityController {
  
  private RequestCache requestCache = new HttpSessionRequestCache();
  
  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
  
  @Autowired
  private SecurityProperties securityProperties;
  
  @Autowired
  private ProviderSignInUtils providerSignInUtils;
  
  /**
   * 当需要身份认证时跳转到这里
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("/authentication/require")
  @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
  public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
    // 获取引发跳转的请求
    SavedRequest savedRequest = requestCache.getRequest(request, response);
    if (savedRequest != null) {
      String target = savedRequest.getRedirectUrl();
      log.info("引发跳转的url: {}", target);
      
      if (StringUtils.endsWithIgnoreCase(target, ".html")) {
        redirectStrategy.sendRedirect(request, response,
          securityProperties.getBrowser().getLoginPage());
      }
    }
    
    return new SimpleResponse("访问服务需要身份认证");
  }

  @GetMapping("/social/user")
  public SocialUserInfo getSocialUserInfo(HttpServletRequest request) {
    SocialUserInfo userInfo = new SocialUserInfo();
    Connection<?> connection = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
    userInfo.setProviderId(connection.getKey().getProviderId());
    userInfo.setProviderUserId(connection.getKey().getProviderUserId());
    userInfo.setNickname(connection.getDisplayName());
    userInfo.setHeadimg(connection.getImageUrl());
    
    return userInfo;
  }
}
