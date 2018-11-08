package com.ssm.dao;

import com.ssm.domain.UsersInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    /***
     * 根据username查询
     * @param username
     * @return
     */
    UsersInfo findLogin(String username);

    /***
     * 查询所有的用户
     * @return
     */
    List<UsersInfo> findAll();


    /**
     * 添加一个用户
     *
     * @param usersInfo
     */
    void addUsersInfo(UsersInfo usersInfo);


    /**
     * 根据Id查询UsersInfo
     *
     * @param userId
     * @return
     */
    UsersInfo findUsersInfoById(String userId);


    /**
     * 更新userInfo
     *
     * @param usersInfo
     */
    void updateUser(UsersInfo usersInfo);

    /**
     * 删除用户
     */
    void delUserById(String id);

    /**
     * 根据userId删除关联表中的记录
     *
     * @param id
     */
    void delRoleByUserId(String id);

    /**
     * 根据userId删除权限
     *
     * @param id
     */
    void delPermissionByUserId(String id);


    /**
     * 给用户添加角色
     * @param userId
     * @param roleId
     */
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);

}
