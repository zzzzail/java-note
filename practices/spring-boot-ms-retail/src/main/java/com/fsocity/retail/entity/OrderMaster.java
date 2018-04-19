package com.fsocity.retail.entity;

import com.fsocity.retail.enums.OrderPayStatusEnum;
import com.fsocity.retail.enums.OrderStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zail
 * @version imp01.0.0
 */
@Entity
@DynamicUpdate // 字段更新
@Data
public class OrderMaster {

  // 订单id
  @Id
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
  private Integer orderStatus = OrderStatusEnum.NEW.getCode();

  // 支付状态, 默认0等待支付
  private Integer payStatus = OrderPayStatusEnum.WAIT.getCode();

  private Date createTime;

  private Date updateTime;

}
