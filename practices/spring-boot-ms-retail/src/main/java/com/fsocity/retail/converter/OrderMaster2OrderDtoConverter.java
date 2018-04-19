package com.fsocity.retail.converter;

import com.fsocity.retail.dto.OrderDto;
import com.fsocity.retail.entity.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 转换器
 *
 * @author zail
 * @version imp01.0.0
 */
public class OrderMaster2OrderDtoConverter {

  public static OrderDto convert(OrderMaster orderMaster) {
    OrderDto orderDto = new OrderDto();
    BeanUtils.copyProperties(orderMaster, orderDto);
    return orderDto;
  }

  public static List<OrderDto> convert(List<OrderMaster> orderMasterList) {
    return orderMasterList.stream()
      .map(e -> convert(e))
      .collect(Collectors.toList());
  }

}
