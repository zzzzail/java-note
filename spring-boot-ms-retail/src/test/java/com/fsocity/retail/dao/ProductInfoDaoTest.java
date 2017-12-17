package com.fsocity.retail.dao;

import com.fsocity.retail.entity.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
public class ProductInfoDaoTest {

  @Autowired
  private ProductDao productDao;

  @Test
  public void saveTest() {
    ProductInfo productInfo = new ProductInfo();
    productInfo.setProductId("test_id_01");
    productInfo.setProductName("测试商品");
    productInfo.setProductPrice(new BigDecimal(10.0));
    productInfo.setProductStock(99);
    productInfo.setProductDescription("这里是说明");
    productInfo.setProductIcon("http://www.fsocity.com/icon");
    productInfo.setProductStatus(0);
    productInfo.setCategoryType(1);
    ProductInfo result = productDao.save(productInfo);
    assertNotNull(result);
  }

  @Test
  public void findByProductStatus() throws Exception {
    List<ProductInfo> productInfoList = productDao.findByProductStatus(0);
    assertNotEquals(0, productInfoList.size());
  }

}