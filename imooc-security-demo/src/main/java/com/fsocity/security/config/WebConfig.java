package com.fsocity.security.config;

import com.fsocity.security.filter.TimeFilter;
import com.fsocity.security.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zail
 * @since 2017-12-26
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
  
  @Autowired
  private TimeInterceptor timeInterceptor;
  
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(timeInterceptor);
  }
  
  @Bean
  public FilterRegistrationBean timeFilter() {
    FilterRegistrationBean bean = new FilterRegistrationBean();
    TimeFilter filter = new TimeFilter();
    bean.setFilter(filter);
    
    List<String> urls = new ArrayList<>();
    urls.add("/*");
    bean.setUrlPatterns(urls);
    
    return bean;
  }
  
}
