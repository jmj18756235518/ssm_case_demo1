package com.ssm.domain;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {

  private String productId;     //商品ID
  private String productNum;   //商品编号
  private String productName;   //商品名称
  private String cityName;   //城市


  private Date departureTime; //触发时间日期
  private String departureTimeStr; //触发时间日期字符串
  private String departureTimeStrUp;   //更新页面回显功能专用


  private Double productPrice;  //商品价格
  private String productDesc;  //商品描述
  private int productStatus;  //状态
  private String productStatusStr;  //产品装填字符串

  @Override
  public String toString() {
    return "Product{" +
            "productId='" + productId + '\'' +
            ", productNum='" + productNum + '\'' +
            ", productName='" + productName + '\'' +
            ", cityName='" + cityName + '\'' +
            ", departureTime=" + departureTime +
            ", departureTimeStr='" + departureTimeStr + '\'' +
            ", productPrice=" + productPrice +
            ", productDesc='" + productDesc + '\'' +
            ", productStatus=" + productStatus +
            ", productStatusStr='" + productStatusStr + '\'' +
            ", departureTimeStrUp='" + departureTimeStrUp + '\'' +
            '}';
  }

  public String getDepartureTimeStr() {
    if(departureTime != null){
      departureTimeStr = new SimpleDateFormat("yyyy年MM月dd日").format(departureTime);
    }
    return departureTimeStr;
  }

  public void setDepartureTimeStr(String departureTimeStr) {
    this.departureTimeStr = departureTimeStr;
  }

  public String getProductStatusStr() {
    if(productStatus == 0){
      productStatusStr = "关闭";
    }else {
      productStatusStr = "打开";
    }
    return productStatusStr;
  }

  public void setProductStatusStr(String productStatusStr) {
    this.productStatusStr = productStatusStr;
  }

  public String getDepartureTimeStrUp() {
    if(departureTime != null){
      departureTimeStrUp = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(departureTime);
    }
    return departureTimeStrUp;
  }

  public void setDepartureTimeStrUp(String departureTimeStrUp) {
    this.departureTimeStrUp = departureTimeStrUp;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getProductNum() {
    return productNum;
  }

  public void setProductNum(String productNum) {
    this.productNum = productNum;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public Date getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(Date departureTime) {
    this.departureTime = departureTime;
  }

  public Double getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(Double productPrice) {
    this.productPrice = productPrice;
  }

  public String getProductDesc() {
    return productDesc;
  }

  public void setProductDesc(String productDesc) {
    this.productDesc = productDesc;
  }

  public int getProductStatus() {
    return productStatus;
  }

  public void setProductStatus(int productStatus) {
    this.productStatus = productStatus;
  }
}
