package com.ssm.domain;


import java.util.List;

public class UsersInfo {

    private String userId;   //用户Id
    private String email;   //用户的email
    private String username;  //用户名
    private String password;   //用户密码
    private String phoneNum;   //电话号码

    private int status;   //状态
    private String statusStr;   //状态友好显示

    //一个用户可以有多个角色，一个角色也对应多个用户（多对多的关系）
    List<Role> roleList;

    @Override
    public String toString() {
        return "Users{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getStatusStr() {
        if (status == 0) {
            statusStr = "未开启";
        } else {
            statusStr = "已开启";
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
