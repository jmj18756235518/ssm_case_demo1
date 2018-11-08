package com.ssm.service;

import com.ssm.domain.Orders;

import java.util.List;

public interface OrdersService {

    /***
     * 查询所有的订单
     * @return
     */
    List<Orders> findAll(Orders orders,int page, int size);

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
