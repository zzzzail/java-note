package com.fsocity.retail.entity;

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
@DynamicUpdate
@Data
public class OrderDetail {

  @Id
  private String detailId;

  // 订单id
  private String orderId;

  // 商品id
  private String productId;

  // 商品名称
  private String productName;

  // 商品价格
  private BigDecimal productPrice;

  // 商品数量
  private Integer productQuantity;

  // 商品小图
  private String productIcon;

  private Date createTime;

  private Date updateTime;

}
