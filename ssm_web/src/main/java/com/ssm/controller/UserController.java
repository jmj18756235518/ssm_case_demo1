package com.ssm.controller;

import com.ssm.domain.Role;
import com.ssm.domain.UsersInfo;
import com.ssm.service.RoleService;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * 查询所有的用户
     * @param model
     * @return
     */
    @RequestMapping("/findAll")
//    @Secured("ROLE_ADMIN")
   /* @PreAuthorize("authentication.principal.username == 'admin'")*/
    public String findAll(Model model) {
        List<UsersInfo> infos = userService.findAll();
        model.addAttribute("users", infos);

        return "user-list";
    }

    /***
     * 添加用户
     * 注意： 密码需要加密
     * @param usersInfo
     * @return
     */
    @RequestMapping("/addUser")
    public String addUsersInfo(UsersInfo usersInfo) {

        System.out.println(usersInfo);
        userService.addUsersInfo(usersInfo);
        return "redirect:/user/findAll";
    }

    /**
     * 用户详情
     *
     * @return
     */
    @RequestMapping("/findUsersInfoById")
    public String findUsersInfoById(String id, Model model) {
        UsersInfo usersInfo = userService.findUsersInfoById(id);
        model.addAttribute("user", usersInfo);
        System.out.println(usersInfo.getRoleList());
        return "user-show";
    }

    /**
     * 修改用户回显功能
     *
     * @return
     */
    @RequestMapping("/findUsersInfoEach")
    public String findUsersInfoEach(String id, Model model) {
        UsersInfo user = userService.findUsersInfoById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    /**
     * 添加用户
     *
     * @param usersInfo
     * @return
     */
    @RequestMapping("/updateUser")
    public String updateUser(UsersInfo usersInfo) {
        System.out.println(usersInfo);
        userService.updateUser(usersInfo);
        return "redirect:/user/findAll";
    }

    /**
     * 批量删除
     *
     * @return
     */
    @RequestMapping("/delUserById")
    public String delUserById(String ids) {

        System.out.println(ids);
        //页面获取到所有的id
        userService.delUserById(ids);
        return "redirect:/user/findAll";
    }


    /**
     * 查询所有的角色，将ID于角色都存到Model中，在页面中展示
     *
     * @return
     */
    @RequestMapping("/findUserByIdAndAllRole")
    public String findUserByIdAndAllRole(String id, Model model) {

        //查询到所有的角色的集合
        List<Role> roleList = roleService.findAll();
        //根据id去查询用户所拥有的角色集合
        List<Role> userRoles = roleService.findRoleByUserId(id);

        for (Role role : roleList) {
            for (Role userRole : userRoles) {
                if (role.equals(userRole)) {
                    role.setFlag(1);    //标记为，让页面选中
                }
            }
        }

        model.addAttribute("userId", id);
        model.addAttribute("roleList", roleList);
        System.out.println(roleList);
        return "user-role-add";
    }


    /**
     * 给用户分配角色
     * 注意事项:
     * 分配用户分为两步，
     * 第一步就是先删除此用户的所有的角色，
     * 第二部是将所有的选中的id关联
     *
     * @return
     */
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(String userId, String roleIds) {

        //删除此用户的所有角色关联
        userService.delRoleByUserId(userId);
        if (roleIds != null) {
            //创建所有的新关联
            userService.addRoleToUser(userId, roleIds);
        }

        return "redirect:/user/findAll";
    }

}
