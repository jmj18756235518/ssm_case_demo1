package com.ssm.service.impl;

import com.ssm.dao.UserDao;
import com.ssm.domain.Role;
import com.ssm.domain.UsersInfo;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    //自动注入加密类     此类属于spring security
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 添加用户
     * @param usersInfo
     */

    @Override
    public void addUsersInfo(UsersInfo usersInfo) {

        //对密码进行加密
        usersInfo.setPassword(bCryptPasswordEncoder.encode(usersInfo.getPassword()));
        System.out.println("测试加密后的密码:---" + usersInfo.getPassword());
        userDao.addUsersInfo(usersInfo);
    }

    /***
     * 查询用户的详情
     * @param userId
     * @return
     */
    @Override
    public UsersInfo findUsersInfoById(String userId) {

        UsersInfo usersInfo = userDao.findUsersInfoById(userId);
        return usersInfo;
    }


    /**
     * 更新用户
     * @param usersInfo
     */
    @Override
    public void updateUser(UsersInfo usersInfo) {
        userDao.updateUser(usersInfo);
    }

    /**
     * 根据id删除
     * @param ids
     */
    @Override
    public void delUserById(String ids) {

        String[] id = ids.split(",");
        //对获取到的所有的id进行遍历，一个一个的删除
        for (int i = 0; i < id.length; i++) {

            /**
                再删除用户之前首先要删除关联表   用户角色关联表
                delete from user_role where userid = 'ids'
             */
            userDao.delRoleByUserId(id[i]);

            /***
             * 再删除角色表与权限表的关联
             */
            userDao.delPermissionByUserId(id[i]);
            //最后再删除用户的id
            userDao.delUserById(id[i]);
        }

    }

    /**
     * 根据用户的ID去删除用户角色关联表中的此用户的所有的关联
     * @param id
     */
    @Override
    public void delRoleByUserId(String id) {
        userDao.delRoleByUserId(id);
    }

    /**
     * 给此用户添加多个角色
     * @param userId
     * @param ids
     */
    @Override
    public void addRoleToUser(String userId, String ids) {

        String[] roleIds = ids.split(",");
        for (String roleId : roleIds) {
            userDao.addRoleToUser(userId,roleId);
            System.out.println(userId+","+roleId);
        }

    }
    //2222

    //5555
    /***
     * 查询所有的用户
     * @return  所有用户的List集合
     *
     * 此处对权限进行了控制，只允许为ADMIN的角色进行操作
     */
    @Override
    @RolesAllowed("ADMIN")
    public List<UsersInfo> findAll() {
        List<UsersInfo> usersInfos = userDao.findAll();
        System.out.println(usersInfos);
        return usersInfos;
    }


    /***
     * 用户登录
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println(username);   //登录名称
        UsersInfo usersInfo = userDao.findLogin(username);

        System.out.println(usersInfo);
        User user = new User(usersInfo.getUsername(),usersInfo.getPassword(),
                usersInfo.getStatus()==1?true:false,true,true,true,getAuthority(usersInfo.getRoleList()));

        return user;
    }

    //作用就是返回一个List集合，集合中封装的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

}
