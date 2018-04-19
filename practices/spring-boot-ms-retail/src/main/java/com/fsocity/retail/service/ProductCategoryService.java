package com.fsocity.retail.service;

import com.fsocity.retail.entity.ProductCategory;

import java.util.List;

/**
 * @author zail
 * @version imp01.0.0
 */
public interface ProductCategoryService {

  // 根据id查询类目
  ProductCategory findOne(Integer id);

  // 查询所有类目
  List<ProductCategory> findAll();

  // 根据type数据, 查询类目
  List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

  // 保存类目
  ProductCategory save(ProductCategory productCategory);

}
