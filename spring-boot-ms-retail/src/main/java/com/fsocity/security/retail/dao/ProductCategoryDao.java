package com.fsocity.security.retail.dao;

import com.fsocity.retail.entity.ProductCategory;
import com.fsocity.security.retail.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author zail
 * @version imp01.0.0
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {

  List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
