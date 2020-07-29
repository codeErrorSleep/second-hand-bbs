package com.example.demo5.controller;


import com.example.demo5.system.domain.Role;
import com.example.demo5.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        model.addAttribute("role",new Role());
        model.addAttribute("roleList",roleService.listRole(pageable));
        return "admin/roles";
    }

    /**
    * 新增角色
    * @author      qiushao
    * @date        20-6-9 下午8:02
    */
    @RequestMapping(value = "admin/addRole", method = RequestMethod.POST)
    String addRole(Role role, Model model) {
        System.out.println(role.getRemark());

        roleService.addRole(role);

        return "redirect:/admin/roles";
    }


    /**
    * 更新角色信息
    * @author      qiushao
    * @date        20-6-9 下午8:02
    */
    @RequestMapping(value = "admin/updateRole", method = RequestMethod.POST)
    String updateRole(Role role, Model model) {
        System.out.println(role.getRemark());
        roleService.updateRole(role);
        return "redirect:/admin/roles";
    }



    /**
    * 删除角色信息
    * @author      qiushao
    * @date        20-6-9 下午10:59
    */
    @RequestMapping("/role/delete/{roleId}")
    public String roleDelete(@PathVariable Long roleId, Model model, HttpSession session) {
//        删除角色信息 boolean
        if(roleService.deleteRole(roleId)){
            model.addAttribute("message","成功删除商品");
            System.out.println("成功删除商品"+roleId);
        }else{
            model.addAttribute("message","删除商品失败");
            System.out.println("删除商品失败"+roleId);

        }

        return "redirect:/admin/roles";



    }

}
