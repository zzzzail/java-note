package com.fsocity.retail.service.impl;

import com.fsocity.retail.dto.OrderDto;
import com.fsocity.retail.entity.OrderDetail;
import com.fsocity.retail.enums.OrderPayStatusEnum;
import com.fsocity.retail.enums.OrderStatusEnum;
import com.fsocity.retail.service.OrderService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zail
 * @version imp01.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

  @Autowired
  private OrderService orderService;

  private String OPENID = "test_order_buyer_openid_01";
  private String ORDER_ID = "1511323058132822261";

  @Test
  public void create() throws Exception {
    OrderDto orderDto = new OrderDto();
    orderDto.setBuyerName("张二狗");
    orderDto.setBuyerPhone("18396800680");
    orderDto.setBuyerAddress("北京市");
    orderDto.setBuyerOpenid(OPENID);

    List<OrderDetail> orderDetailList = new ArrayList<>();

    OrderDetail orderDetail1 = new OrderDetail();
    orderDetail1.setProductId("test_id_01");
    orderDetail1.setProductQuantity(2);
    orderDetailList.add(orderDetail1);

    OrderDetail orderDetail2 = new OrderDetail(); // 测试买第二件商品
    orderDetail2.setProductId("test_id_02");
    orderDetail2.setProductQuantity(2);
    orderDetailList.add(orderDetail2);

    orderDto.setOrderDetailList(orderDetailList);
    OrderDto result = orderService.create(orderDto);
    System.out.println(result);
    assertNotNull(result);
  }

  @Test
  public void findOne() throws Exception {
    OrderDto orderDto = orderService.findOne(ORDER_ID);
    System.out.println(orderDto);
    assertEquals(ORDER_ID, orderDto.getOrderId());
  }

  @Test
  public void findList() throws Exception {
    PageRequest pageRequest = new PageRequest(0, 5);
    Page<OrderDto> orderDtoPage = orderService.findList(OPENID, pageRequest);
    assertNotEquals(0, orderDtoPage.getTotalElements());
  }

  @Test
  public void cancel() throws Exception {
    OrderDto orderDto = orderService.findOne(ORDER_ID);
    OrderDto result = orderService.cancel(orderDto);
    Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
  }

  @Test
  public void finish() throws Exception {
    OrderDto orderDto = orderService.findOne(ORDER_ID);
    OrderDto result = orderService.finish(orderDto);
    assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
  }

  @Test
  public void paid() throws Exception {
    OrderDto orderDto = orderService.findOne(ORDER_ID);
    OrderDto result = orderService.paid(orderDto);
    Assert.assertEquals(OrderPayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
  }

}
