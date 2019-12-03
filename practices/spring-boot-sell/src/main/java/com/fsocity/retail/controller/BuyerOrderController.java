package com.fsocity.retail.controller;

import com.fsocity.retail.converter.OrderForm2OrderDtoConverter;
import com.fsocity.retail.dto.OrderDto;
import com.fsocity.retail.enums.HTTPResponseEnum;
import com.fsocity.retail.exception.SellException;
import com.fsocity.retail.form.OrderForm;
import com.fsocity.retail.service.BuyerService;
import com.fsocity.retail.service.OrderService;
import com.fsocity.retail.utils.HTTPResponseVoUtil;
import com.fsocity.retail.vo.HTTPResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zail
 * @version imp01.0.0
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
  
  @Autowired
  private OrderService orderService;
  
  @Autowired
  private BuyerService buyerService;
  
  // 创建订单
  @PostMapping("/create")
  public HTTPResponseVo<Map<String, String>> create(@Valid OrderForm orderForm,
                                                    BindingResult bindingResult) {
    
    if (bindingResult.hasErrors()) {
      log.error("[创建订单]: 参数不正确, orderFrom={}", orderForm);
      throw new SellException(
        HTTPResponseEnum.PARAM_ERROR.getCode(),
        bindingResult.getFieldError().getDefaultMessage());
    }
    
    OrderDto orderDto = OrderForm2OrderDtoConverter.convert(orderForm);
    if (CollectionUtils.isEmpty(orderDto.getOrderDetailList())) {
      log.error("[创建订单]: 购物车不能为空.");
      throw new SellException(HTTPResponseEnum.CART_EMPTY);
    }
    
    OrderDto createResult = orderService.create(orderDto);
    
    Map<String, String> map = new HashMap<>();
    map.put("orderId", createResult.getOrderId());
    
    return HTTPResponseVoUtil.success(map);
  }
  
  // 订单列表
  @GetMapping("/list")
  public HTTPResponseVo<List<OrderDto>> list(
    @RequestParam("openid") String openid,
    @RequestParam(value = "_pageNum", defaultValue = "0") Integer pageNum,
    @RequestParam(value = "_pageSize", defaultValue = "10") Integer pageSize) {
    
    if (StringUtils.isEmpty(openid)) {
      log.error("[查询订单列表]: openid 为空");
      throw new SellException(HTTPResponseEnum.PARAM_ERROR);
    }
    
    Pageable pageable = PageRequest.of(pageNum, pageSize);
    Page<OrderDto> orderDtoPage = orderService.findList(openid, pageable);
    
    return HTTPResponseVoUtil.success(orderDtoPage.getContent());
  }
  
  // 订单详情
  @GetMapping("/detail")
  public HTTPResponseVo<OrderDto> detail(@RequestParam("openid") String openid,
                                         @RequestParam("orderId") String orderId) {
    
    // 查询订单
    OrderDto orderDto = buyerService.findOrderOne(openid, orderId);
    
    return HTTPResponseVoUtil.success(orderDto);
  }
  
  // 取消订单
  @PostMapping("/cancel")
  public HTTPResponseVo cancel(@RequestParam("openid") String openid,
                               @RequestParam("orderId") String orderId) {
    // 取消订单
    buyerService.cancelOrder(openid, orderId);
    return HTTPResponseVoUtil.success();
  }
  
}
