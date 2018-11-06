package com.ssm.dao;

import com.ssm.domain.Permission;

import java.util.List;

public interface PermissionDao {

    /***
     * 根据角色的Id通过关联表去查询到对应的所有的权限
     * @return
     */
    List<Permission> findPermissionByRoleId(String roleId);

    /***
     * 查询所有的权限
     * @return
     */
    List<Permission> findAll();


    /**
     * 添加权限
     * @param permission
     */
    void addPermission(Permission permission);

}
