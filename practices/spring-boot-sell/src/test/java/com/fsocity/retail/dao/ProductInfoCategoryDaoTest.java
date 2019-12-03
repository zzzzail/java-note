package com.fsocity.retail.dao;

import com.fsocity.retail.entity.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zail
 * @version imp01.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoCategoryDaoTest {

  @Autowired
  private ProductCategoryDao productCategoryDao;

  @Test
  public void saveTest() {
    ProductCategory productCategory = new ProductCategory();
    productCategory.setCategoryName("热门推荐");
    productCategory.setCategoryType(1);
    productCategoryDao.save(productCategory);
  }

  @Test
  public void findOneTest() {
    ProductCategory productCategory = productCategoryDao.findById(1).orElse(null);
    
    System.out.println(productCategory);
  }

}
