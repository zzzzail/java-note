package com.fsocity.retail.converter;

import com.fsocity.retail.dto.OrderDto;
import com.fsocity.retail.entity.OrderDetail;
import com.fsocity.retail.enums.HTTPResponseEnum;
import com.fsocity.retail.exception.SellException;
import com.fsocity.retail.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zail
 * @version imp01.0.0
 */
@Slf4j
public class OrderForm2OrderDtoConverter {

  public static OrderDto convert(OrderForm orderForm) {
    OrderDto orderDto = new OrderDto();
    orderDto.setBuyerName(orderForm.getName());
    orderDto.setBuyerPhone(orderForm.getPhone());
    orderDto.setBuyerAddress(orderForm.getAddress());
    orderDto.setBuyerOpenid(orderForm.getOpenid());

    List<OrderDetail> orderDetailList = new ArrayList<>();
    Gson gson = new Gson();
    try {
      orderDetailList = gson.fromJson(orderForm.getItems(),
        new TypeToken<List<OrderDetail>>(){}.getType());
    }
    catch (JsonSyntaxException e) {
      log.error("[Json 对象转换]: 错误, string={}", orderForm.getItems());
      throw new SellException(HTTPResponseEnum.PARAM_ERROR);
    }
    orderDto.setOrderDetailList(orderDetailList);

    return orderDto;
  }

}
