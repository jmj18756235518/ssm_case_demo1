package com.ssm.dao;

import com.ssm.domain.Traveller;

import java.util.List;

public interface TravellerDao {

    /**
     * 根据订单编号通过关联表进行查询到对应的游客
     * @return
     */
    List<Traveller> findTravellerByOrderId(String orderId);
}
