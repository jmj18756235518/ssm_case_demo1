package com.ssm.domain;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Orders {

  private String orderId;    //订单id
  private String orderNum;   //订单编号

  private Date orderTime;   //订单创建时间（下单时间）
  private String orderTimeStr;

  private int peopleCount;     //人数
  private String orderDesc;   //订单描述

  private int payType;    //支付类型   0支付宝  1 微信  2银行卡
  private String payTypeStr;  //支付类型友好显示 转换后的形式


  private int orderStatus;   //订单状态
  private String orderStatusStr;  //订单的状态友好显示

  private String productId;   //商品的id
  private String memberId;   //会员id

  //一个订单对应一个产品
  private Product product;   //一个订单的id对应一个产品id

  //一个订单对应一个会员   根据会员的id去查询到会员
  private Member member;


  //一个订单下面有多个旅客   根据订单的id通过关联表进行子查询
  private List<Traveller> travellerList ;



  public Member getMember() {
    return member;
  }

  public void setMember(Member member) {
    this.member = member;
  }

  public List<Traveller> getTravellerList() {
    return travellerList;
  }

  public void setTravellerList(List<Traveller> travellerList) {
    this.travellerList = travellerList;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  /**
   * 对数据库中查询到的日期进行转换
   * @return
   */
  public String getOrderTimeStr() {
    if(orderTime != null){
      orderTimeStr = new SimpleDateFormat("yyyy-MM-dd HH:ss").format(orderTime);
    }
    return orderTimeStr;
  }

  public void setOrderTimeStr(String orderTimeStr) {
    this.orderTimeStr = orderTimeStr;
  }

  /***
   * 将用户支付方式转换为友好的显示方式
   * @return
   */
  public String getPayTypeStr() {
    if(payType == 0){
      payTypeStr = "支付宝";
    }else if(payType == 1){
      payTypeStr = "微信";
    }else if(payType == 2){
      payTypeStr = "银行卡";
    }
    return payTypeStr;
  }

  public void setPayTypeStr(String payTypeStr) {
    this.payTypeStr = payTypeStr;
  }

  /***
   * 转换订单的状态
   * @return
   */
  public String getOrderStatusStr() {
    if(orderStatus == 0){
      orderStatusStr = "未支付";
    }else {
      orderStatusStr = "已支付";
    }
    return orderStatusStr;
  }

  public void setOrderStatusStr(String orderStatusStr) {
    this.orderStatusStr = orderStatusStr;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getOrderNum() {
    return orderNum;
  }

  public void setOrderNum(String orderNum) {
    this.orderNum = orderNum;
  }

  public Date getOrderTime() {
    return orderTime;
  }

  public void setOrderTime(Date orderTime) {
    this.orderTime = orderTime;
  }

  public int getPeopleCount() {
    return peopleCount;
  }

  public void setPeopleCount(int peopleCount) {
    this.peopleCount = peopleCount;
  }

  public String getOrderDesc() {
    return orderDesc;
  }


  public void setOrderDesc(String orderDesc) {
    this.orderDesc = orderDesc;
  }

  public int getPayType() {
    return payType;
  }

  public void setPayType(int payType) {
    this.payType = payType;
  }

  public int getOrderStatus() {
    return orderStatus;
  }

  @Override
  public String toString() {
    return "Orders{" +
            "orderId='" + orderId + '\'' +
            ", orderNum='" + orderNum + '\'' +
            ", orderTime=" + orderTime +
            ", orderTimeStr='" + orderTimeStr + '\'' +
            ", peopleCount=" + peopleCount +
            ", orderDesc='" + orderDesc + '\'' +
            ", payType=" + payType +
            ", payTypeStr='" + payTypeStr + '\'' +
            ", orderStatus=" + orderStatus +
            ", orderStatusStr='" + orderStatusStr + '\'' +
            ", productId='" + productId + '\'' +
            ", memberId='" + memberId + '\'' +
            ", product=" + product +
            '}';
  }

  public void setOrderStatus(int orderStatus) {
    this.orderStatus = orderStatus;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getMemberId() {
    return memberId;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }
}
