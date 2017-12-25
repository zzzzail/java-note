package com.fsocity.security.retail.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author zail
 * @version imp01.0.0
 */
@Data
public class OrderForm {

  // 买家姓名
  @NotEmpty(message = "买家姓名必填")
  private String name;

  // 买家手机号码
  @NotEmpty(message = "手机号码必填")
  private String phone;

  // 买家地址
  @NotEmpty(message = "地址必填")
  private String address;

  // 买家微信openid
  @NotEmpty(message = "openid必填")
  private String openid;

  // 购物车
  @NotEmpty(message = "购物车不能为空")
  private String items;

}
