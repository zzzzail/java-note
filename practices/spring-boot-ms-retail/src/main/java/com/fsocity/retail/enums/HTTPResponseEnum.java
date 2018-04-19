package com.fsocity.retail.enums;

import lombok.Getter;

/**
 * @author zail
 * @version 1.0.0
 */
@Getter
public enum HTTPResponseEnum {

  SUCCESS(0, "Success!"),
  PARAM_ERROR(1, "Param is fail."),
  PRODUCT_NOT_EXIST(40, "Product is not exist."),
  PRODUCT_STOCK_ERROR(41, "Product stock error."),
  ORDER_NOT_EXIST(60, "Order is not exist."),
  ORDER_DETAIL_NOT_EXIST(61, "Order detail is not exist."),
  ORDER_STATUS_ERROR(62, "Order status error."),
  ORDER_UPDATE_FAIL(63, "Update order fail."),
  ORDER_DETAIL_EMPTY(64, "Order detail is empty."),
  ORDER_PAY_STATUS_ERROR(65, "Order pay status error."),
  CART_EMPTY(66, "Cart is empty."),
  ORDER_OWNER_ERROR(67, "Your openid and order's openid are different.")
  ;

  private Integer code;
  private String message;

  HTTPResponseEnum(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

}
