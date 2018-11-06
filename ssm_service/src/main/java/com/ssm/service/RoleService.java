package com.ssm.service;

import com.ssm.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {

    /**
     * 查询所有的role
     * @return
     */
    List<Role> findAll();


    /**
     * 添加角色
     * @param role
     */
    void addRole(Role role);

    /**
     * 根据id查询角色，角色详情
     * @return
     */
    Role findRoleById(String id);

    /***
     * 根据id去修改此角色
     * @param role
     */
    void updateRoleById(Role role);


    /***
     * 通过用户的id去查询此用户下面所有的角色
     * @param userId
     * @return
     */
    List<Role> findRoleByUserId(String userId);

    /**
     * 根据角色的id去删除权限与角色关联表对应此roleId的所有的记录
     * @param roleId
     */
    void dePermissionByRoleId(String roleId);

    /**
     * 添加角色与权限的关联
     * 给角色添加权限，与权限进行关联
     * @param roleId
     * @param permissionIds
     */
    void addPermissionToRole(String roleId,String permissionIds);

}
