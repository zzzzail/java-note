package com.fsocity.retail.enums;

import lombok.Getter;

/**
 * @author zail
 * @version 0.0.1
 */
@Getter
public enum OrderStatusEnum {
  NEW(0, "new order."),
  FINISHED(1, "order finished."),
  CANCEL(2, "cancel order.")
  ;

  private Integer code;
  private String message;

  OrderStatusEnum(Integer code, String message) {
    this.code = code;
    this.message = message;
  }
}
