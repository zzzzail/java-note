package com.fsocity.security.core.social.qq.connect;

import com.fsocity.security.core.social.qq.api.QQ;
import com.fsocity.security.core.social.qq.api.QQImpl;
import lombok.Data;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

/**
 * @author zail
 * @since 2018-01-19
 */
@Data
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {
  
  // qq 互联 appId
  private String appId;
  
  private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";
  private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";
  
  /**
   * Create a new {@link OAuth2ServiceProvider}.
   * @param appId 申请qq互联时的 clientId
   * @param appSecret 申请qq互联时的 clientSecret
   */
  public QQServiceProvider(String appId, String appSecret) {
    super(new QQOAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
    this.appId = appId;
  }
  
  @Override
  public QQ getApi(String accessToken) {
    return new QQImpl(accessToken, appId);
  }
}
