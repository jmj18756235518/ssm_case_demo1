package com.ssm.controller;


import com.github.pagehelper.PageInfo;
import com.ssm.domain.Orders;
import com.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;


    /**
     * 查询所有的订单
     * @param model
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Orders orders,Model model,
      @RequestParam(name = "page", required = true, defaultValue = "1") int page,
      @RequestParam(name = "size", required = true, defaultValue = "3") int size
    ) {
        List<Orders> ordersList = ordersService.findAll(orders,page, size);
        System.out.println();
        System.out.println(page+","+size);
        PageInfo pageInfo=new PageInfo(ordersList);
        System.out.println(pageInfo);
        System.out.println(pageInfo.getList());

        //将查询到的所有订单信息存储到ordersList
        model.addAttribute("pageInfo", pageInfo);

        return "orders-list";
    }

    /**
     * 订单详情
     * 一个订单对应一个会员
     * 一个订单对应多个游客（使用关联表子查询）
     * model中存储orders对象、product对象、member对象、List<traveller>对象
     * @return  订单详情页面
     */
    @RequestMapping("/ordersDetails")
    public String ordersDetails(String id,Model model){

        //根据id去查询订单下面的所有内容
        Orders order = ordersService.findOrderById(id);
        System.out.println(order.getMember());
        System.out.println(order.getTravellerList());
        //获取到product对象  也是根据订单的id去查寻到订单对应的商品  一个订单对应一个商品
        model.addAttribute("order",order);
        return "orders-show";
    }

    /**
     * 页面回显功能
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/ordersEcho")
    public String ordersEcho(String id,Model model){
        //同上面一样，根据订单id去查询到此订单下面的所有的内容
        Orders order = ordersService.findOrderById(id);
        model.addAttribute("order",order);
        //System.out.println(order);
        return "orders-update";

    }

    @RequestMapping("/updateOrderById")
    public String updateOrderById(Orders orders){

        System.out.println(orders);
        //ordersService.updateOrderById(orders);


        //重定向在此查询订单，更新状态
        return "redirect:/orders/findAll";
    }

    /***
     * 多选删除订单   页面传过来的参数是多个 id，所以要在service层进行遍历删除操作
     * 注意事项：（下面的所有的操作套在循环体中，并且放在service中执行，不然事务控制管理器无法控制）
     *     订单表与会员表有关联   是一对一的关系   所以先要将订单对应的会员删除（通过会员的id去会员表中删除）
     *          delete from member where id = (select memberid from orders where id = 'ordersId(页面获取到的)')
     *     订单表与产品表有关联   是一对一的关系   所以也要先将订单对应的产品删除（通过产品id去产品表中删除）
     *          delete from product where id = (select productid from orders where id = 'ordersId')
     *     订单与游客之间通过关联表关联  所以先要将关联表中的包含订单编号的记录删除（通过订单编号删除）
     *          delete from order_traveller where orderid = 'ordersId'
     *
     *  最后删除了所有的关联之后再去删除订单记录
     *      delete from orders where id = 'orders'(页面获取)
     * @param ids
     * @return
     */
    @RequestMapping("/delOrderBySel")
    public String delOrderBySel(String ids){
        //业务逻辑在service中执行，
        System.out.println(ids);
        return "orders-list";
    }

}
