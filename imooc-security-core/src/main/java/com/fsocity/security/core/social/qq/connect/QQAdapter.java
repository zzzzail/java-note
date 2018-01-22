package com.fsocity.security.core.social.qq.connect;

import com.fsocity.security.core.social.qq.api.QQ;
import com.fsocity.security.core.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @author zail
 * @since 2018-01-19
 */
public class QQAdapter implements ApiAdapter<QQ> {
  
  // 测试 api 是否可用
  @Override
  public boolean test(QQ api) {
    return true;
  }
  
  /**
   * @param api
   * @param values
   */
  @Override
  public void setConnectionValues(QQ api, ConnectionValues values) {
    QQUserInfo userInfo = api.getUserInfo();
    values.setDisplayName(userInfo.getNickname());
    values.setImageUrl(userInfo.getFigureurl_1());
    values.setProfileUrl(null);
    values.setProviderUserId(userInfo.getOpen_id());
  }
  
  @Override
  public UserProfile fetchUserProfile(QQ api) {
    return null;
  }
  
  @Override
  public void updateStatus(QQ api, String message) {
    // do nothing
  }
}
