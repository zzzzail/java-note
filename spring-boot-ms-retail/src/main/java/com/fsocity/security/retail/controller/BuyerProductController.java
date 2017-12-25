package com.fsocity.security.retail.controller;

import com.fsocity.retail.entity.ProductInfo;
import com.fsocity.retail.entity.ProductCategory;
import com.fsocity.retail.service.ProductCategoryService;
import com.fsocity.retail.service.ProductService;
import com.fsocity.retail.utils.HTTPResponseVoUtil;
import com.fsocity.retail.vo.BuyerProductVo;
import com.fsocity.retail.vo.HTTPResponseVo;
import com.fsocity.retail.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 *
 * @author zail
 * @version imp01.0.0
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

  @Autowired
  private ProductService productService;

  @Autowired
  private ProductCategoryService productCategoryService;

  @GetMapping("/list")
  public HTTPResponseVo list() {
    // imp01. 查询所有上架商品
    List<ProductInfo> productInfoList = productService.findUpAll();

    // 2. 查询类目(一次性查询)
    // 传统方法
    // List<Integer> categoryTypeList = new ArrayList<>();
    // for (ProductInfo product : productInfoList) {
    //   categoryTypeList.add(product.getCategoryType());
    // }
    List<Integer> categoryTypeList = productInfoList.stream()
      .map(e -> e.getCategoryType())
      .collect(Collectors.toList());
    List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

    // 3. 数据拼装
    List<BuyerProductVo> buyerProductVos = new ArrayList<>();
    for (ProductCategory productCategory : productCategoryList) {
      BuyerProductVo buyerProductVo = new BuyerProductVo();
      buyerProductVo.setCategoryName(productCategory.getCategoryName());
      buyerProductVo.setCategoryType(productCategory.getCategoryType());

      List<ProductVo> productVoList = new ArrayList<>();
      for (ProductInfo productInfo : productInfoList) {
        if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
          ProductVo productVo = new ProductVo();
          productVo.setProductId(productInfo.getProductId());
          productVo.setProductName(productInfo.getProductName());
          productVo.setProductPrice(productInfo.getProductPrice());
          productVo.setProductDescription(productInfo.getProductDescription());
          productVo.setProductIcon(productInfo.getProductIcon());
          productVoList.add(productVo);
        }
      }
      buyerProductVo.setProductVoList(productVoList);
      buyerProductVos.add(buyerProductVo);
    }

    return HTTPResponseVoUtil.success(buyerProductVos);
  }

}
