package com.fsocity.security.core.social;

import com.fsocity.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

/**
 * @author zail
 * @since 2018-01-19
 */
@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {
  
  @Autowired
  private DataSource dataSource;
  
  @Autowired
  private SecurityProperties securityProperties;
  
  @Autowired
  private ConnectionFactoryLocator connectionFactoryLocator;
  
  @Autowired(required = false)
  private ConnectionSignUp connectionSignUp;
  
  @Override
  public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
    JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
    repository.setTablePrefix("imooc_");
    
    if (connectionSignUp != null) {
      repository.setConnectionSignUp(connectionSignUp);
    }
    return repository;
  }
  
  @Bean
  public SpringSocialConfigurer imoocSocialSecurityConfig() {
    String filterProcessUrl = securityProperties.getSocial().getFilterProcessorUrl();
    ImoocSpringSocialConfigurer configurer = new ImoocSpringSocialConfigurer(filterProcessUrl);
    configurer.signupUrl(securityProperties.getBrowser().getSignUpUrl());
    return configurer;
  }
  
  @Bean
  public ProviderSignInUtils providerSignInUtils() {
    return new ProviderSignInUtils(
      connectionFactoryLocator,
      getUsersConnectionRepository(connectionFactoryLocator));
  }
}
