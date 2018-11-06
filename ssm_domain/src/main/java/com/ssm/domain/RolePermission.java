package com.ssm.domain;


public class RolePermission {

  private String permissionId;   //权限Id
  private String roleId;    //角色ID

  public String getPermissionId() {
    return permissionId;
  }

  public void setPermissionId(String permissionId) {
    this.permissionId = permissionId;
  }

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }
}
