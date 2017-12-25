package com.fsocity.security.retail.service;

import com.fsocity.retail.dto.OrderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author zail
 * @version imp01.0.0
 */
public interface OrderService {

  // 创建订单
  OrderDto create(OrderDto orderDto);

  // 查询一个订单
  OrderDto findOne(String orderId);

  // 查询订单列表
  Page<OrderDto> findList(String buyerOpenid, Pageable pageable);

  // 取消订单
  OrderDto cancel(OrderDto orderDto);

  // 完结订单
  OrderDto finish(OrderDto orderDto);

  // 支付订单
  OrderDto paid(OrderDto orderDto);

}
