package com.fsocity.security.core.properties;

/**
 * 用到的常量
 * @author zail
 * @since 2018-01-16
 */
public class SecurityConstants {
  
  /**
   * 默认处理验证码的 url 前缀
   */
  public static final String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";
  
  /**
   * 当请求需要认证时, 默认跳转的 url
   */
  public static final String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";
  
  /**
   * 默认的用户名密码登录请求处理 url
   */
  public static final String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/authentication/form";
  
  /**
   * 默认手机验证码登录请求处理 url
   */
  public static final String DEFAULT_LOGIN_PROCESSING_URL_MOBILE = "/authentication/mobile";
  
  /**
   * 默认登录页
   */
  public static final String DEFAULT_LOGIN_PAGE_URL = "/signin.html";
  
  /**
   * 验证图片验证码时, http请求中默认的携带图片验证码信息的参数的名称
   */
  public static final String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";
  
  /**
   * 验证短信验证码时, http请求中默认的携带短信验证码信息的参数的名称
   */
  public static final String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
  
  /**
   * 发送短信验证码 或 验证短信验证码时，传递手机号的参数的名称
   */
  public static final String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";
  
  /**
   * session失效默认的跳转地址
   */
  public static final String DEFAULT_SESSION_INVALID_URL = "/session/invalid";
}
