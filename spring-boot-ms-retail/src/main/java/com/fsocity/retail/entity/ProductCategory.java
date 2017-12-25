package com.fsocity.retail.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author zail
 * @version imp01.0.0
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory {

  @Id
  @GeneratedValue
  private Integer categoryId;
  private String categoryName; // 类目名称
  private Integer categoryType; // 类目编号
  private Date createTime;
  private Date updateTime;

  public ProductCategory() {
  }

  public ProductCategory(String categoryName, Integer categoryType) {
    this.categoryName = categoryName;
    this.categoryType = categoryType;
  }
}
