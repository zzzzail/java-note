package com.fsocity.security.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fsocity.security.browser.support.SimpleResponse;
import com.fsocity.security.core.properties.LoginType;
import com.fsocity.security.core.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zail
 * @since 2017-12-28
 */
@Component("imoocAuthenticationFailureHandler")
@Slf4j
public class ImoocAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
  
  @Autowired
  private ObjectMapper objectMapper;
  
  @Autowired
  private SecurityProperties securityProperties;
  
  @Override
  public void onAuthenticationFailure(HttpServletRequest request,
                                      HttpServletResponse response,
                                      AuthenticationException exception) throws IOException, ServletException {
    
    log.info("登录失败");
    
    if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
      response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
      response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
      response.getWriter().write(
        objectMapper.writeValueAsString(new SimpleResponse(exception.getMessage()))
      );
    }
    else {
      super.onAuthenticationFailure(request, response, exception);
    }
    
  }
  
}
