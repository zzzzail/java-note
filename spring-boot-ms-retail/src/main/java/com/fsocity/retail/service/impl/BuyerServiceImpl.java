package com.fsocity.retail.service.impl;

import com.fsocity.retail.dto.OrderDto;
import com.fsocity.retail.enums.HTTPResponseEnum;
import com.fsocity.retail.exception.SellException;
import com.fsocity.retail.service.BuyerService;
import com.fsocity.retail.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zail
 * @version imp01.0.0
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

  @Autowired
  private OrderService orderService;

  @Override
  public OrderDto findOrderOne(String openid, String orderId) {
    return checkOrderOwner(openid, orderId);
  }

  @Override
  public OrderDto cancelOrder(String openid, String orderId) {
    OrderDto orderDto = checkOrderOwner(openid, orderId);
    if (orderDto == null) {
      log.error("[查询订单]: 订单不存在, orderId={}", orderId);
      throw new SellException(HTTPResponseEnum.ORDER_NOT_EXIST);
    }
    return orderService.cancel(orderDto);
  }

  /**
   * 检查用户openid和订单openid是否一致
   */
  private OrderDto checkOrderOwner(String openid, String orderId) {
    OrderDto orderDto = orderService.findOne(orderId);
    if (orderDto == null) return null;

    // 判断openid是否一致
    if (!orderDto.getBuyerOpenid().equalsIgnoreCase(openid)) {
      log.error("[查询订单]: 订单openid不一致, openid={}, orderDto={}", openid, orderDto);
      throw new SellException(HTTPResponseEnum.ORDER_OWNER_ERROR);
    }
    return orderDto;
  }

}
