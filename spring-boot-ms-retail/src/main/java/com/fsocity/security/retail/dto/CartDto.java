package com.fsocity.security.retail.dto;

import lombok.Data;

/**
 * @author zail
 * @version imp01.0.0
 */
@Data
public class CartDto {

  // 商品id
  private String productId;

  // 商品数量
  private Integer productQuantity;

  public CartDto() {
  }

  public CartDto(String productId, Integer productQuantity) {
    this.productId = productId;
    this.productQuantity = productQuantity;
  }
}
