package com.fsocity.security.retail.service.impl;

import com.fsocity.retail.entity.ProductInfo;
import com.fsocity.retail.enums.ProductStatusEnum;
import com.fsocity.security.retail.entity.ProductInfo;
import com.fsocity.security.retail.enums.ProductStatusEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zail
 * @version imp01.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

  @Autowired
  private ProductServiceImpl productService;

  @Test
  public void findOne() throws Exception {
    ProductInfo productInfo = productService.findOne("test_id_01");
    assertEquals("test_id_01", productInfo.getProductId());
  }

  @Test
  public void findUpAll() throws Exception {
    List<ProductInfo> productInfoList = productService.findUpAll();
    assertNotEquals(0, productInfoList.size());
  }

  @Test
  public void findAll() throws Exception {
    PageRequest pageRequest = new PageRequest(0, 2);
    Page<ProductInfo> productPage = productService.findAll(pageRequest);
    // System.out.println(productPage.getTotalElements());
    assertNotEquals(0, productPage.getTotalElements());
  }

  @Test
  public void save() throws Exception {
    ProductInfo productInfo = new ProductInfo();
    productInfo.setProductId("test_id_02");
    productInfo.setProductName("皮皮虾");
    productInfo.setProductPrice(new BigDecimal(10.0));
    productInfo.setProductStock(99);
    productInfo.setProductDescription("这里是说明");
    productInfo.setProductIcon("http://www.fsocity.com/icon");
    productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
    productInfo.setCategoryType(1);
    ProductInfo result = productService.save(productInfo);
    assertNotNull(result);
  }

}
