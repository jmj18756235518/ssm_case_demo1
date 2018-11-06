package com.ssm.domain;


public class Traveller {

    private String travellerId;   //旅客的id
    private String travellerName;    //旅客姓名
    private String sex;   //旅客的性别
    private String phoneNum;   //电话号码

    private int credentialsType;  //身份证类型
    private String credentialsTypeStr; //身份证的类型友好显示

    private String credentialsNum;  //身份证号码

    private int travellerType;     //旅客类型

    @Override
    public String toString() {
        return "Traveller{" +
                "travellerId='" + travellerId + '\'' +
                ", travellerName='" + travellerName + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", credentialsType=" + credentialsType +
                ", credentialsNum='" + credentialsNum + '\'' +
                ", travellerType=" + travellerType +
                '}';
    }

    public String getCredentialsTypeStr() {
        if (credentialsType == 0) {
            credentialsTypeStr = "身份证";
        } else {
            credentialsTypeStr = "其他";
        }
        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getTravellerId() {
        return travellerId;
    }

    public void setTravellerId(String travellerId) {
        this.travellerId = travellerId;
    }

    public String getTravellerName() {
        return travellerName;
    }

    public void setTravellerName(String travellerName) {
        this.travellerName = travellerName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(int credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public int getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(int travellerType) {
        this.travellerType = travellerType;
    }
}
