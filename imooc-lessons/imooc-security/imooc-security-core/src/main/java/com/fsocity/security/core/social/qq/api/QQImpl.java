package com.fsocity.security.core.social.qq.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.io.IOException;

/**
 * @author zail
 * @since 2018-01-19
 */
@Slf4j
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ  {
  
  // 获取 openId 的 url
  private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";
  
  // 获取用户信息的 url
  private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";
  
  // qq互联上申请的 appId
  private String appId;
  
  // 用户的qq号码
  private String openId;
  
  private ObjectMapper objectMapper = new ObjectMapper();
  
  public QQImpl(String accessToken, String appId) {
    // TokenStrategy.ACCESS_TOKEN_PARAMETER 设置到 url 查询参数中
    super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
    
    this.appId = appId;
    
    String url = String.format(URL_GET_OPENID, accessToken);
    String result = getRestTemplate().getForObject(url, String.class);

    log.info(result);
    
    this.openId = StringUtils.substringBetween(result, "\"openid\":\"" , "\"}");
  }
  
  @Override
  public QQUserInfo getUserInfo() {
    String url = String.format(URL_GET_USERINFO, appId, openId);
    String result = getRestTemplate().getForObject(url, String.class);
  
    log.info(result);
    QQUserInfo userInfo = null;
    try {
      userInfo = objectMapper.readValue(result, QQUserInfo.class);
      userInfo.setOpen_id(openId);
      return userInfo;
    }
    catch (IOException e) {
      throw new RuntimeException("获取用户信息失败.", e);
    }
  }
}
