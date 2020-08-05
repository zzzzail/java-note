package com.fsocity.security.core.social.qq.connect;

import com.fsocity.security.core.social.qq.api.QQ;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * @author zail
 * @since 2018-01-19
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {
  /**
   * Create a {@link OAuth2ConnectionFactory}.
   */
  public QQConnectionFactory(String providerId, String appId, String appSecret) {
    super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
  }
}
