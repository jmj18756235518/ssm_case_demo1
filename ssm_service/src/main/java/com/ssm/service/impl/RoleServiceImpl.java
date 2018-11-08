package com.ssm.service.impl;

import com.ssm.dao.RoleDao;
import com.ssm.domain.Role;
import com.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    /**
     * 查询所有的角色
     * @return
     */
    @Override
    public List<Role> findAll() {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }

    /***
     * 添加一个角色
     * @param role
     */
    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    /**
     * 根据id删除role
     * @param id
     * @return
     */
    @Override
    public Role findRoleById(String id) {
        Role roleById = roleDao.findRoleById(id);
        return roleById;
    }

    /**
     * 根据角色的id去更新角色
     * @param role
     */
    @Override
    public void updateRoleById(Role role) {
        roleDao.updateRoleById(role);
    }

    /**
     * 根据用户的ID去查询此用户下面的所有的角色
     * @param userId
     * @return
     */
    @Override
    public List<Role> findRoleByUserId(String userId) {

        List<Role> userRoles = roleDao.findRoleByUserId(userId);
        return userRoles;
    }

    /**
     * 根据角色的id去删除权限与角色关联表对应此roleId的所有的记录
     * @param roleId
     */
    @Override
    public void dePermissionByRoleId(String roleId) {
        roleDao.dePermissionByRoleId(roleId);
    }

    /**
     * 添加角色与权限的关联
     * 给角色添加权限，与权限进行关联
     * @param roleId
     * @param permissionIds
     */
    @Override
    public void addPermissionToRole(String roleId, String permissionIds) {

        String[] perIds = permissionIds.split(",");
        for (String perId : perIds) {

            roleDao.addPermissionToRole(roleId,perId);
        }
    }


}
