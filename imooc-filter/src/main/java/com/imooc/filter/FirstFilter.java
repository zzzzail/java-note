package com.imooc.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器
 * @author zail
 * @since 2018-02-05
 */
public class FirstFilter implements Filter {
  
  /**
   * 过滤器的初始化方法, Web容器创建过滤器实例后将调用该方法, 这个方法可以读取web.xml文件中过滤器的参数.
   * @param filterConfig
   * @throws ServletException
   */
  public void init(FilterConfig filterConfig) throws ServletException {
  
  }
  
  /**
   * 完成实际的过滤操作, 过滤器的核心方法, 当用户请求访问与过滤器关联的URL时,
   * Web 容器将先调用过滤器的doFilter方法.
   * FilterChain 参数可以调用chain.doFilter方法将请求传给下一个过滤器(或目标资源),
   * 或利用转发、重定向将请求转发到其它资源.
   * @param request
   * @param response
   * @param chain
   * @throws IOException
   * @throws ServletException
   */
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
  
  }
  
  /**
   * Web容器在销毁过滤器前调用的方法, 这个方法中可以释放过滤器占用的资源. (大多数情况下用不到)
   */
  public void destroy() {
  
  }
}
