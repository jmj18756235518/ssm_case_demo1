package com.ssm.controller;

import com.ssm.domain.Permission;
import com.ssm.domain.Role;
import com.ssm.service.PermissionService;
import com.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    /**
     * 查询所有的角色
     *
     * @param model
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model) {

        List<Role> roleList = roleService.findAll();
        model.addAttribute("roleList", roleList);
        return "role-list";
    }

    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    @RequestMapping("/addRole")
    public String addRole(Role role) {
        roleService.addRole(role);
        return "redirect:/role/findAll";
    }

    /***
     * 角色详情
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/findRoleById")
    public String findRoleById(String id, Model model) {

        Role role = roleService.findRoleById(id);
        model.addAttribute("role", role);
        return "role-show";
    }

    /**
     * 角色添加的回显数据
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/roleEcho")
    public String roleEcho(String id,Model model){
        Role role = roleService.findRoleById(id);
        model.addAttribute("role",role);
        return "role-update";
    }

    /**
     * 根据角色的id去更新角色
     * @param role
     * @return
     */
    @RequestMapping("/updateRoleById")
    public String updateRoleById(Role role){

        roleService.updateRoleById(role);
        return "redirect:/role/findAll";
    }

    /**
     * 根据Id去批量删除此Role
     * @return
     */
    @RequestMapping("/delRoleById")
    public String delRoleById(String id){

        System.out.println(id);

        return "redirect:/role/findAll";
    }

    /***
     * 给角色分配权限
     * 并且将角色所拥有的权限存到model域中
     * @return
     */
    @RequestMapping("/findPermissionByRoleId")
    public String findPermissionByRoleId(String id,Model model){

        //查询所有的权限
        List<Permission> permissions = permissionService.findAll();
        //查询此角色下面的所有角色
        List<Permission> rolePermissions = permissionService.findPermissionByRoleId(id);

        for (Permission permission : permissions) {
            for (Permission rolePermission : rolePermissions) {
                if(permission.equals(rolePermission)){

                    //标记为1，等会在前端页面显示的时候就标记为1
                    permission.setFlag(1);
                }
            }
        }

        model.addAttribute("permissions",permissions);
        //将角色的id也存到model中，等会在添加的时候需要用到
        model.addAttribute("roleId",id);
        return "role-permission-add";
    }

    /**
     * 给角色分配权限
     * 1.先根据角色的id清除所有的权限
     * 2.再根据角色的id与
     * @return
     */
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(String roleId,String permissionIds){

        //清空所有的角色
        roleService.dePermissionByRoleId(roleId);

        if(permissionIds != null){

            //再添加所有选中的新的权限
            roleService.addPermissionToRole(roleId,permissionIds);
        }
        //重定向
        return "redirect:/role/findAll";
    }
}
