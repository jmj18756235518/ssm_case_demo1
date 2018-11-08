package com.ssm.dao;

import com.ssm.domain.Orders;

import java.util.List;

public interface OrdersDao {

    /***
     * 查询所有的订单
     * @return
     */
    List<Orders> findAll(Orders orders);

    /**
     * 根据id查询ordersId
     * @param ordersId
     * @return
     */
    Orders findOrderById(String ordersId);

    /**
     * 根跟新订单
     * @param orders
     */
    void updateOrderById(Orders orders);

}
