package com.fsocity.security.retail.vo;

import lombok.Data;

/**
 * HTTP 请求返回的对象
 * @author zail
 * @version imp01.0.0
 */
@Data
public class HTTPResponseVo<T> {

  /** 错误码 */
  private Integer code;

  /** 提示信息 */
  private String message;

  /** 返回具体数据 */
  private T data;

}
