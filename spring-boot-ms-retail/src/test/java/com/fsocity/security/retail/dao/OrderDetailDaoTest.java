package com.fsocity.security.retail.dao;

import com.fsocity.retail.entity.OrderDetail;
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
public class OrderDetailDaoTest {

  @Autowired
  private OrderDetailDao orderDetailDao;

  @Test
  public void save() throws Exception {
    OrderDetail orderDetail = new OrderDetail();
    orderDetail.setDetailId("order_detail_id_02");
    orderDetail.setOrderId("order_detail_order_id_01");
    orderDetail.setProductId("order_detail_product_id_01");
    orderDetail.setProductName("张二狗");
    orderDetail.setProductPrice(new BigDecimal(99.5));
    orderDetail.setProductQuantity(10);
    orderDetail.setProductIcon("http://www.fsocity.com/icon");

    OrderDetail result = orderDetailDao.save(orderDetail);
    assertNotNull(result);
  }

  @Test
  public void findByOrderId() throws Exception {
    List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId("order_detail_order_id_01");
    assertNotEquals(0, orderDetailList.size());
  }

}
