package com.ssm.domain;


import java.util.List;

public class Permission {

  private String permissionId;   //权限ID
  private String permissionName;  //权限名称
  private String url;   //资源路径
  private int flag;  //标记

  public int getFlag() {
    return flag;
  }

  public void setFlag(int flag) {
    this.flag = flag;
  }

  /***
   * 重写equals方法
   * @param o
   * @return
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Permission that = (Permission) o;

    if (permissionId != null ? !permissionId.equals(that.permissionId) : that.permissionId != null) return false;
    if (permissionName != null ? !permissionName.equals(that.permissionName) : that.permissionName != null)
      return false;
    return url != null ? url.equals(that.url) : that.url == null;
  }

  //一个权限下面有多个角色
  private List<Role> roleList;

  public String getPermissionId() {
    return permissionId;
  }

  public void setPermissionId(String permissionId) {
    this.permissionId = permissionId;
  }

  public String getPermissionName() {
    return permissionName;
  }

  public void setPermissionName(String permissionName) {
    this.permissionName = permissionName;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public List<Role> getRoleList() {
    return roleList;
  }

  public void setRoleList(List<Role> roleList) {
    this.roleList = roleList;
  }

  @Override
  public String toString() {
    return "Permission{" +
            "permissionId='" + permissionId + '\'' +
            ", permissionName='" + permissionName + '\'' +
            ", url='" + url + '\'' +
            ", flag=" + flag +
            ", roleList=" + roleList +
            '}';
  }
}
