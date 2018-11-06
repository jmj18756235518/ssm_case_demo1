package com.ssm.controller;


import com.ssm.domain.Permission;
import com.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    /***
     * 查询所有的权限
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Permission> all = permissionService.findAll();

        model.addAttribute("permissionList",all);
        return "permission-list";
    }


    /***
     * 添加资源权限
     * @param permission
     * @return
     */
    @RequestMapping("/addPermission")
    public String addPermission(Permission permission){
        permissionService.addPermission(permission);
        return "redirect:/permission/findAll";
    }

}
