package com.fsocity.security.core.social.qq.config;

import com.fsocity.security.core.properties.QQProperties;
import com.fsocity.security.core.properties.SecurityProperties;
import com.fsocity.security.core.social.qq.connect.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

/**
 * @author zail
 * @since 2018-01-19
 *
 * 当配置文件中配置好 imooc.security.social.qq.app-id 时, 该配置生效
 * @ConditionalOnProperty(prefix = "imooc.security.social.qq", name = "app-id")
 */
@Configuration
@ConditionalOnProperty(prefix = "imooc.security.social.qq", name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {
  
  @Autowired
  private SecurityProperties securityProperties;
  
  @Override
  protected ConnectionFactory<?> createConnectionFactory() {
    QQProperties qqConfig = securityProperties.getSocial().getQq();
    
    return new QQConnectionFactory(
      qqConfig.getProviderId(),
      qqConfig.getAppId(),
      qqConfig.getAppSecret());
  }
}
