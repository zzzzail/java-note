package com.fsocity.security.retail.service.impl;

import com.fsocity.retail.dao.ProductCategoryDao;
import com.fsocity.retail.entity.ProductCategory;
import com.fsocity.retail.service.ProductCategoryService;
import com.fsocity.security.retail.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zail
 * @version imp01.0.0
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

  @Autowired
  private ProductCategoryDao productCategoryDao;

  @Override
  public ProductCategory findOne(Integer id) {
    return productCategoryDao.findOne(id);
  }

  @Override
  public List<ProductCategory> findAll() {
    return productCategoryDao.findAll();
  }

  @Override
  public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
    return productCategoryDao.findByCategoryTypeIn(categoryTypeList);
  }

  @Override
  public ProductCategory save(ProductCategory productCategory) {
    return productCategoryDao.save(productCategory);
  }
}
