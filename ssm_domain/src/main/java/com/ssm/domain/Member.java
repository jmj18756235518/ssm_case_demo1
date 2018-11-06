package com.ssm.domain;


public class Member {

  private String memberId;  //会员id
  private String memberName;   //会员名称
  private String nickName;   //昵称
  private String phoneNum;   //电话号码
  private String email;  //电子邮件

  @Override
  public String toString() {
    return "Member{" +
            "memberId='" + memberId + '\'' +
            ", memberName='" + memberName + '\'' +
            ", nickName='" + nickName + '\'' +
            ", phoneNum='" + phoneNum + '\'' +
            ", email='" + email + '\'' +
            '}';
  }

  public String getMemberId() {
    return memberId;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }

  public String getMemberName() {
    return memberName;
  }

  public void setMemberName(String memberName) {
    this.memberName = memberName;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public String getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
