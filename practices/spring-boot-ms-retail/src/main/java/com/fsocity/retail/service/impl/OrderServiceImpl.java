package com.fsocity.retail.service.impl;

import com.fsocity.retail.converter.OrderMaster2OrderDtoConverter;
import com.fsocity.retail.dao.OrderDetailDao;
import com.fsocity.retail.dao.OrderMasterDao;
import com.fsocity.retail.dto.CartDto;
import com.fsocity.retail.dto.OrderDto;
import com.fsocity.retail.entity.OrderDetail;
import com.fsocity.retail.entity.OrderMaster;
import com.fsocity.retail.entity.ProductInfo;
import com.fsocity.retail.enums.HTTPResponseEnum;
import com.fsocity.retail.enums.OrderPayStatusEnum;
import com.fsocity.retail.enums.OrderStatusEnum;
import com.fsocity.retail.exception.SellException;
import com.fsocity.retail.service.OrderService;
import com.fsocity.retail.service.ProductService;
import com.fsocity.retail.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zail
 * @version imp01.0.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

  @Autowired
  private ProductService productService;

  @Autowired
  private OrderDetailDao orderDetailDao;

  @Autowired
  private OrderMasterDao orderMasterDao;

  @Override
  @Transactional
  public OrderDto create(OrderDto orderDto) {
    BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
    String orderId = KeyUtil.generatorUniqueKey();
    orderDto.setOrderId(orderId);

    // List<CartDto> cartDtoList = new ArrayList<>();

    // imp01. 查询商品(数量, 价格)
    for (OrderDetail orderDetail : orderDto.getOrderDetailList()) {
      ProductInfo productInfo = productService.findOne(orderDetail.getProductId());

      // 商品不存在
      if (productInfo == null) {
        throw new SellException(HTTPResponseEnum.PRODUCT_NOT_EXIST);
      }

      // 2. 计算订单总价
      orderAmount = productInfo.getProductPrice()
        .multiply(new BigDecimal(orderDetail.getProductQuantity()))
        .add(orderAmount);

      // 订单详情入库
      orderDetail.setDetailId(KeyUtil.generatorUniqueKey());
      orderDetail.setOrderId(orderId);
      BeanUtils.copyProperties(productInfo, orderDetail);
      orderDetailDao.save(orderDetail);

      // CartDto cartDto = new CartDto(orderDetail.getProductId(), orderDetail.getProductQuantity());
      // cartDtoList.add(cartDto);
    }
    // 判断库存数量是否足够

    // 3. 写入订单数据库(OrderMaster 和 OrderDetail)
    OrderMaster orderMaster = new OrderMaster();
    // copy 操作可以 copy null 值.
    BeanUtils.copyProperties(orderDto, orderMaster,
      new String[]{"orderStatus", "payStatus"}); // 不 copy 这两个元素
    orderMaster.setOrderAmount(orderAmount);
    orderMasterDao.save(orderMaster);

    // 4. 扣库存
    List<CartDto> cartDtoList = orderDto.getOrderDetailList().stream()
      .map(e -> new CartDto(e.getProductId(), e.getProductQuantity()))
      .collect(Collectors.toList());
    productService.decreaseStock(cartDtoList);

    return orderDto;
  }

  @Override
  public OrderDto findOne(String orderId) {
    OrderMaster orderMaster = orderMasterDao.findOne(orderId);

    // 订单不存在
    if (orderMaster == null) {
      throw new SellException(HTTPResponseEnum.ORDER_NOT_EXIST);
    }

    List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId(orderId);
    // 订单没有商品
    if (CollectionUtils.isEmpty(orderDetailList)) {
      throw new SellException(HTTPResponseEnum.ORDER_DETAIL_NOT_EXIST);
    }

    OrderDto orderDto = new OrderDto();
    BeanUtils.copyProperties(orderMaster, orderDto);
    orderDto.setOrderDetailList(orderDetailList);

    return orderDto;
  }

  @Override
  public Page<OrderDto> findList(String buyerOpenid, Pageable pageable) {
    Page<OrderMaster> orderMasterPage = orderMasterDao.findByBuyerOpenid(buyerOpenid, pageable);
    List<OrderDto> orderDtoList = OrderMaster2OrderDtoConverter.convert(orderMasterPage.getContent());

    return new PageImpl<OrderDto>(
      orderDtoList,
      pageable,
      orderMasterPage.getTotalElements());
  }

  @Override
  @Transactional
  public OrderDto cancel(OrderDto orderDto) {
    // imp01. 判断订单的状态
    if (!orderDto.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
      log.error("[取消订单]: 订单状态不正确, orderId={}, orderStatus={}", orderDto.getOrderId(), orderDto.getOrderStatus());
      throw new SellException(HTTPResponseEnum.ORDER_STATUS_ERROR);
    }

    // 2. 修改订单状态
    OrderMaster orderMaster = new OrderMaster();
    orderDto.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
    BeanUtils.copyProperties(orderDto, orderMaster);
    OrderMaster updateResult = orderMasterDao.save(orderMaster);
    if (updateResult == null) {
      log.error("[取消订单]: 更新失败, orderMaster={}", orderMaster);
      throw new SellException(HTTPResponseEnum.ORDER_UPDATE_FAIL);
    }

    // 3. 返还库存
    if (CollectionUtils.isEmpty(orderDto.getOrderDetailList())) {
      log.error("[取消订单]: 订单中无商品, orderDto={}", orderDto);
      throw new SellException(HTTPResponseEnum.ORDER_DETAIL_EMPTY);
    }
    List<CartDto> cartDtoList = orderDto.getOrderDetailList().stream()
      .map(e -> new CartDto(e.getProductId(), e.getProductQuantity()))
      .collect(Collectors.toList());
    productService.increaseStock(cartDtoList);

    // 4. 如果已支付, 给用户退款
    if (orderDto.getPayStatus().equals(OrderPayStatusEnum.SUCCESS.getCode())) {
      // TODO: 退款操作
    }
    return orderDto;
  }

  @Override
  public OrderDto finish(OrderDto orderDto) {
    // imp01. 判断订单状态
    if (!orderDto.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
      log.error("[完结订单]: 订单状态不正确, orderId={}, orderStatus={}", orderDto.getOrderId(), orderDto.getOrderStatus());
      throw new SellException(HTTPResponseEnum.ORDER_STATUS_ERROR);
    }

    // 2. 修改状态
    orderDto.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
    OrderMaster orderMaster = new OrderMaster();
    BeanUtils.copyProperties(orderDto, orderMaster);
    OrderMaster updateResult = orderMasterDao.save(orderMaster);
    if (updateResult == null) {
      log.error("[完结订单]: 更新失败, orderMaster={}", orderMaster);
      throw new SellException(HTTPResponseEnum.ORDER_UPDATE_FAIL);
    }

    return orderDto;
  }

  @Override
  @Transactional
  public OrderDto paid(OrderDto orderDto) {
    // imp01. 判断订单状态
    if (!orderDto.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
      log.error("[支付订单]: 订单状态不正确, orderId={}, orderStatus={}", orderDto.getOrderId(), orderDto.getOrderStatus());
      throw new SellException(HTTPResponseEnum.ORDER_STATUS_ERROR);
    }

    // 2. 判断支付状态
    if (!orderDto.getPayStatus().equals(OrderPayStatusEnum.WAIT.getCode())) {
      log.error("[支付订单]: 支付状态不正确, orderDto={}", orderDto);
      throw new SellException(HTTPResponseEnum.ORDER_PAY_STATUS_ERROR);
    }

    // 2. 修改支付状态
    orderDto.setPayStatus(OrderPayStatusEnum.SUCCESS.getCode());
    OrderMaster orderMaster = new OrderMaster();
    BeanUtils.copyProperties(orderDto, orderMaster);
    OrderMaster updateResult = orderMasterDao.save(orderMaster);
    if (updateResult == null) {
      log.error("[支付订单]: 更新失败, orderMaster={}", orderMaster);
      throw new SellException(HTTPResponseEnum.ORDER_UPDATE_FAIL);
    }

    return orderDto;
  }
}
