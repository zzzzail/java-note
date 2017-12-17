package com.fsocity.retail.dao;

import com.fsocity.retail.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author zail
 * @version imp01.0.0
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail, String> {

  List<OrderDetail> findByOrderId(String orderId);

}
