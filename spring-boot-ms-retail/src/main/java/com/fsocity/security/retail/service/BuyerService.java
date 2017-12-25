package com.fsocity.security.retail.service;

import com.fsocity.retail.dto.OrderDto;

/**
 * @author zail
 * @version imp01.0.0
 */
public interface BuyerService {

  // 查询一个订单
  OrderDto findOrderOne(String openid, String orderId);

  // 取消订单
  OrderDto cancelOrder(String openid, String orderId);

}
