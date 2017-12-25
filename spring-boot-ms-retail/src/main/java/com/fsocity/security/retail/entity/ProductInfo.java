package com.fsocity.security.retail.entity;

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
public class ProductInfo {

  @Id
  private String productId;
  private String productName; // 名字
  private BigDecimal productPrice; // 单价
  private Integer productStock; // 库存
  private String productDescription; // 说明
  private String productIcon; // 小图标
  private Integer productStatus; // 状态
  private Integer categoryType; // 类目类型
  private Date createTime;
  private Date updateTime;

  public ProductInfo() {
  }

  public ProductInfo(String productId, String productName, BigDecimal productPrice, Integer productStock, String productDescription, String productIcon, Integer productStatus, Integer categoryType) {
    this.productId = productId;
    this.productName = productName;
    this.productPrice = productPrice;
    this.productStock = productStock;
    this.productDescription = productDescription;
    this.productIcon = productIcon;
    this.productStatus = productStatus;
    this.categoryType = categoryType;
  }
}
