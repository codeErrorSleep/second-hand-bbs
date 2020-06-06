package com.example.demo5.system.controller;


import com.example.demo5.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;



/**
* @Description:    角色的控制类
* @Author:         qiuShao
* @CreateDate:     20-6-6 上午10:47
*/
@Controller
@EnableAutoConfiguration
public class RoleController {

    @Autowired
    private RoleService roleService;


    //角色管理
    @RequestMapping("admin/roles")
    public String roles(Model model,@PageableDefault(size = 8,
            direction = Sort.Direction.DESC) Pageable pageable) {

        System.out.println(roleService.listRole(pageable).getTotalElements());
        model.addAttribute("roleList",roleService.listRole(pageable));

        return "admin/roles";
    }
}
