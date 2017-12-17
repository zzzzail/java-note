package com.fsocity.retail.dao;

import com.fsocity.retail.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author zail
 * @version imp01.0.0
 */
public interface ProductDao extends JpaRepository<ProductInfo, String> {

  List<ProductInfo> findByProductStatus(Integer productStatus);

}
