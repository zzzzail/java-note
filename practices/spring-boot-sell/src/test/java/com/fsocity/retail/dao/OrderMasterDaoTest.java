package com.fsocity.retail.dao;

import com.fsocity.retail.entity.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author zail
 * @version imp01.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {
  
  @Autowired
  private OrderMasterDao orderMasterDao;
  
  private String OPENID = "test_order_buyer_openid_01";
  
  @Test
  public void save() throws Exception {
    OrderMaster orderMaster = new OrderMaster();
    orderMaster.setOrderId("test_order_id_01");
    orderMaster.setBuyerName("张二狗");
    orderMaster.setBuyerPhone("18396800681");
    orderMaster.setBuyerAddress("北京市张二狗区");
    orderMaster.setBuyerOpenid(OPENID);
    orderMaster.setOrderAmount(new BigDecimal(99.5));
    
    OrderMaster result = orderMasterDao.save(orderMaster);
    assertNotNull(result);
  }
  
  @Test
  public void findByBuyerOpenid() throws Exception {
    Pageable pageable = PageRequest.of(0, 5);
    Page<OrderMaster> result = orderMasterDao.findByBuyerOpenid(OPENID, pageable);
    assertNotEquals(0, result.getTotalElements());
  }
  
}
