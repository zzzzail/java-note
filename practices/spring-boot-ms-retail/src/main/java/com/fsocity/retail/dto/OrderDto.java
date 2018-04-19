package com.fsocity.retail.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fsocity.retail.entity.OrderDetail;
import com.fsocity.retail.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author zail
 * @version imp01.0.0
 */
@Data
// @JsonInclude(JsonInclude.Include.NON_NULL) // 解析返回的 json 时不带 null 值
public class OrderDto {

  // 订单id
  private String orderId;

  // 买家姓名
  private String buyerName;

  // 买家电话
  private String buyerPhone;

  // 买家地址
  private String buyerAddress;

  // 买家微信openid
  private String buyerOpenid;

  // 订单总金额
  private BigDecimal orderAmount;

  // 订单状态, 默认0新订单
  private Integer orderStatus;

  // 支付状态, 默认0等待支付
  private Integer payStatus;

  // 创建时间
  // 转换json格式时 (createTime / 1000)
  @JsonSerialize(using = Date2LongSerializer.class)
  private Date createTime;

  @JsonSerialize(using = Date2LongSerializer.class)
  private Date updateTime;

  // 订单详情列表
  List<OrderDetail> orderDetailList;
}
