package com.fsocity.security.retail.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品包含类目
 * @author zail
 * @version imp01.0.0
 */
@Data
public class BuyerProductVo {

  /** 类目名称 */
  @JsonProperty("name")
  private String categoryName;

  /** 类目类型 */
  @JsonProperty("type")
  private Integer categoryType;

  @JsonProperty("foods")
  private List<ProductVo> productVoList;

}
