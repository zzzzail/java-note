package com.fsocity.security.condition;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

/**
 * @author zail
 * @since 2017-12-25
 */
@Data
public class UserQueryCondition {

  @ApiModelProperty(value = "用户名")
  private String username;
  
  @ApiModelProperty(value = "大于等于年龄")
  private int age;
  
  @ApiModelProperty(value = "小于年龄")
  private int ageTo;
  
  @ApiModelProperty(value = "x值")
  private String xxx;
  
}
