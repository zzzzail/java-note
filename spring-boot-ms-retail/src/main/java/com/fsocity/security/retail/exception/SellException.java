package com.fsocity.security.retail.exception;

import com.fsocity.retail.enums.HTTPResponseEnum;

/**
 * @author zail
 * @version imp01.0.0
 */
public class SellException extends RuntimeException {

  private Integer code;

  public SellException(Integer code, String message) {
    super(message);
    this.code = code;
  }

  public SellException(HTTPResponseEnum httpResponseEnum) {
    super(httpResponseEnum.getMessage());
    this.code = httpResponseEnum.getCode();
  }

}
