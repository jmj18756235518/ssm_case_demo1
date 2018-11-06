package com.ssm.domain;


import java.util.List;

public class Role {

  private String roleId;   //角色ID
  private String roleName;  //角色名称
  private String roleDesc;   //角色描述
  private int flag;    //标记



  public int getFlag() {
    return flag;
  }

  public void setFlag(int flag) {
    this.flag = flag;
  }

  //一个角色下面可以有多个用户
  private List<UsersInfo> usersInfoList;

  //一个角色下面可以有多个权限
  private List<Permission> permissionList;

  public List<UsersInfo> getUsersInfoList() {
    return usersInfoList;
  }

  public void setUsersInfoList(List<UsersInfo> usersInfoList) {
    this.usersInfoList = usersInfoList;
  }

  public List<Permission> getPermissionList() {
    return permissionList;
  }

  @Override
  public String toString() {
    return "Role{" +
            "roleId='" + roleId + '\'' +
            ", roleName='" + roleName + '\'' +
            ", roleDesc='" + roleDesc + '\'' +
            ", flag=" + flag +
            '}';
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

    Role role = (Role) o;

    if (roleId != null ? !roleId.equals(role.roleId) : role.roleId != null) return false;
    if (roleName != null ? !roleName.equals(role.roleName) : role.roleName != null) return false;
    return roleDesc != null ? roleDesc.equals(role.roleDesc) : role.roleDesc == null;
  }


  public void setPermissionList(List<Permission> permissionList) {
    this.permissionList = permissionList;
  }

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getRoleDesc() {
    return roleDesc;
  }

  public void setRoleDesc(String roleDesc) {
    this.roleDesc = roleDesc;
  }
}
