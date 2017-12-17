package com.fsocity.learn_spring_boot.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
@Table(name = "spring_boot_user_security")
public class UserSecurity {

  @Id
  @GeneratedValue
  private Integer securityId;

  @ManyToOne(targetEntity = UserInfo.class)
  private Integer userId;

  @Column(length = 100)
  private String userAgent;

  @Column(length = 50)
  private String userIP;

  public UserSecurity() {
  }

  public UserSecurity(Integer securityId, Integer userId, String userAgent, String userIP) {
    this.securityId = securityId;
    this.userId = userId;
    this.userAgent = userAgent;
    this.userIP = userIP;
  }

  public Integer getSecurityId() {
    return securityId;
  }

  public void setSecurityId(Integer securityId) {
    this.securityId = securityId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getUserAgent() {
    return userAgent;
  }

  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }

  public String getUserIP() {
    return userIP;
  }

  public void setUserIP(String userIP) {
    this.userIP = userIP;
  }
}
