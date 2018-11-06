package com.ssm.service.impl;

import com.ssm.dao.PermissionDao;
import com.ssm.domain.Permission;
import com.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

//
    @Autowired
    private PermissionDao permissionDao;

    /***
     * 查询所有的权限
     * @return
     */
    @Override
    public List<Permission> findAll() {

        List<Permission> permissionList = permissionDao.findAll();
        return permissionList;
    }

    /**
     * 根据角色的id去查询角色下面的权限
     * @param roleId
     * @return
     */
    @Override
    public List<Permission> findPermissionByRoleId(String roleId) {

        return  permissionDao.findPermissionByRoleId(roleId);
    }

    /**
     * 添加权限
     * @param permission
     */
    @Override
    public void addPermission(Permission permission) {

        permissionDao.addPermission(permission);
    }
}
