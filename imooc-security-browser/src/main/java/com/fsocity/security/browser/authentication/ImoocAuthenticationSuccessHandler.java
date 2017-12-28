package com.fsocity.security.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

/**
 * @author zail
 * @since 2017-12-28
 */
@Component("imoocAuthenticationSuccessHandler")
@Slf4j
public class ImoocAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
  
  @Autowired
  private ObjectMapper objectMapper;
  
  /**
   * 登录成功后
   * @param request
   * @param response
   * @param authentication
   * @throws IOException
   * @throws ServletException
   */
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request,
                                      HttpServletResponse response,
                                      Authentication authentication) throws IOException, ServletException {
    
    log.info("登录成功");
  
    response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
    response.getWriter().write(objectMapper.writeValueAsString(authentication));
  }
}
