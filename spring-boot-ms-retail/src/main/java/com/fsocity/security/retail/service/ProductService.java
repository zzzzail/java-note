package com.fsocity.security.retail.service;

import com.fsocity.retail.dto.CartDto;
import com.fsocity.retail.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品
 * @author zail
 * @version imp01.0.0
 */
public interface ProductService {

  // 根据 orderId 查找商品
  ProductInfo findOne(String orderId);

  // 查询所有上架商品列表
  List<ProductInfo> findUpAll();

  // 查询所有商品列表
  Page<ProductInfo> findAll(Pageable pageable);

  // 保存
  ProductInfo save(ProductInfo productInfo);

  // 加库存
  void increaseStock(List<CartDto> cartDtoList);

  // 减库存
  void decreaseStock(List<CartDto> cartDtoList);

}
