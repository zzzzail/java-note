package com.fsocity.sell.order.entity;

import lombok.Data;

/**
 * @author zail
 * @since 2019/12/3
 */
@Data
public class Order {
  
  // 订单 id
  private Long id;
  
  // 订单号码
  private String orderNo;
  
  // 商品名称
  private String orderProductName;
  
}
