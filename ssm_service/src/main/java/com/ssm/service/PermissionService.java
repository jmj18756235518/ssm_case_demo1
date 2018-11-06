package com.ssm.service;

import com.ssm.domain.Permission;

import java.util.List;

public interface PermissionService {

    /***
     * 查询所有的权限
     * @return
     */
    List<Permission> findAll();


    /***
     * 根据角色的Id通过关联表去查询到对应的所有的权限
     * @return
     */
    List<Permission> findPermissionByRoleId(String roleId);


    /**
     * 添加权限
     *
     * 添加权限操作
     * @param permission
     */
    void addPermission(Permission permission);
}
