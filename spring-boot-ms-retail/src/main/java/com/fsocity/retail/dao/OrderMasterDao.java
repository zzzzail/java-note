package com.fsocity.retail.dao;

import com.fsocity.retail.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zail
 * @version imp01.0.0
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster, String> {

  // 根据微信openid获取订单
  Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);

}
