package com.fsocity.retail.enums;

import lombok.Getter;

/**
 * @author zail
 * @version imp01.0.0
 */
@Getter
public enum  OrderPayStatusEnum {
  WAIT(0, "wait pay."),
  SUCCESS(1, "pay success!")
  ;

  private Integer code;
  private String message;

  OrderPayStatusEnum(Integer code, String message) {
    this.code = code;
    this.message = message;
  }
}
