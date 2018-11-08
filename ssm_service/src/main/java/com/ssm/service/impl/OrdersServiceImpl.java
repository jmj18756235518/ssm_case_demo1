package com.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.ssm.dao.OrdersDao;
import com.ssm.domain.Orders;
import com.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    /***
     * 查询所有的订单
     * @return
     */
    @Override
    public List<Orders> findAll(Orders orders,int page,int size) {
        //设置每页的起始页码，和每页显示的条数
        PageHelper.startPage(page, size);
        return ordersDao.findAll(orders);
    }

    /**
     * 根据订单的id去查询订单
     * @param ordersId
     * @return
     */
    @Override
    public Orders findOrderById(String ordersId) {

        Orders orderById = ordersDao.findOrderById(ordersId);
        return orderById;
    }

    /**
     * 更新订单
     * @param orders
     */
    @Override
    public void updateOrderById(Orders orders) {
        ordersDao.updateOrderById(orders);
    }
}
