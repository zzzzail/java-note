package com.fsocity.security.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * @author zail
 * @since 2017-12-26
 */
// @Component
public class TimeFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("TimeFilter#init");
  }
  
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    System.out.println("TimeFilter start");
    long start = new Date().getTime();
    chain.doFilter(request, response);
    System.out.println("time filter 耗时: " + (new Date().getTime() - start));
    System.out.println("TimeFilter finish");
  }
  
  @Override
  public void destroy() {
    System.out.println("TimeFilter#destroy");
  }
}
