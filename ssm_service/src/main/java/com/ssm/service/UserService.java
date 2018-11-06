package com.ssm.service;

import com.ssm.domain.Role;
import com.ssm.domain.UsersInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {


    /***
     *
     * 查询所有的用户
     * @return
     */
    List<UsersInfo> findAll();


    /**
     * 添加 用户
     * @param usersInfo
     */
    void addUsersInfo(UsersInfo usersInfo);

    /**
     * 根据Id查询UsersInfo
     * @param userId
     * @return
     */
    UsersInfo findUsersInfoById(String userId);

    /**
     * 更新用户
     * @param usersInfo
     */
    void updateUser(UsersInfo usersInfo);


    /***
     * 根据id删除
     */
    void delUserById(String ids);

    /**
     * 根据userId删除关联表中的记录
     * @param id
     */
    void delRoleByUserId(String id);

    /**
     * 给用户添加角色
     * @param userId
     * @param ids
     */
    void addRoleToUser(String userId,String ids);

}
