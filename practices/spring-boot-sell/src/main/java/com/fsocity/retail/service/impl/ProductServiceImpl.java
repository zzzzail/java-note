package com.fsocity.retail.service.impl;

import com.fsocity.retail.dao.ProductDao;
import com.fsocity.retail.dto.CartDto;
import com.fsocity.retail.entity.ProductInfo;
import com.fsocity.retail.enums.HTTPResponseEnum;
import com.fsocity.retail.enums.ProductStatusEnum;
import com.fsocity.retail.exception.SellException;
import com.fsocity.retail.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zail
 * @version imp01.0.0
 */
@Service
public class ProductServiceImpl implements ProductService {
  
  @Autowired
  private ProductDao productDao;
  
  @Override
  public ProductInfo findOne(String id) {
    return productDao.findById(id).orElse(null);
  }
  
  @Override
  public List<ProductInfo> findUpAll() {
    return productDao.findByProductStatus(ProductStatusEnum.UP.getCode());
  }
  
  @Override
  public Page<ProductInfo> findAll(Pageable pageable) {
    return productDao.findAll(pageable);
  }
  
  @Override
  public ProductInfo save(ProductInfo productInfo) {
    return productDao.save(productInfo);
  }
  
  @Override
  public void increaseStock(List<CartDto> cartDtoList) {
    for (CartDto cartDto : cartDtoList) {
      ProductInfo productInfo = findOne(cartDto.getProductId());
      
      // 如果商品不存在
      if (productInfo == null) {
        throw new SellException(HTTPResponseEnum.PRODUCT_NOT_EXIST);
      }
      
      // 增加库存
      Integer sumProductStock = productInfo.getProductStock() + cartDto.getProductQuantity();
      
      // 设置并保存
      productInfo.setProductStock(sumProductStock);
      productDao.save(productInfo);
    }
  }
  
  @Override
  @Transactional
  public void decreaseStock(List<CartDto> cartDtoList) {
    for (CartDto cartDto : cartDtoList) {
      ProductInfo productInfo = findOne(cartDto.getProductId());
      
      // 如果商品不存在
      if (productInfo == null) {
        throw new SellException(HTTPResponseEnum.PRODUCT_NOT_EXIST);
      }
      
      // TODO: 扣库存的时候存在多扣的情况, 后期使用redis的锁机制辅助扣库存的事
      Integer result = productInfo.getProductStock() - cartDto.getProductQuantity();
      // 如果减去的库存小于0
      if (result < 0) {
        throw new SellException(HTTPResponseEnum.PRODUCT_STOCK_ERROR);
      }
      
      // 设置库存并保存
      productInfo.setProductStock(result);
      productDao.save(productInfo);
    }
  }
  
}
