package com.fsocity.retail.service;

import com.fsocity.retail.dto.OrderDto;
import com.fsocity.retail.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author zail
 * @version imp01.0.0
 */
public interface OrderService {
  
  // 查询订单信息
  OrderMaster findById(String orderId);
  
  // 查询一个订单
  OrderDto findOne(String orderId);
  
  // 创建订单
  OrderDto create(OrderDto orderDto);
  
  
  // 查询订单列表
  Page<OrderDto> findList(String buyerOpenid, Pageable pageable);
  
  // 取消订单
  OrderDto cancel(OrderDto orderDto);
  
  // 完结订单
  OrderDto finish(OrderDto orderDto);
  
  // 支付订单
  OrderDto paid(OrderDto orderDto);
  
}
