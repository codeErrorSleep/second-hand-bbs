package com.secondHandbbs.controller;

import com.secondHandbbs.domain.Role;
import com.secondHandbbs.domain.User;
import com.secondHandbbs.service.*;
import com.secondHandbbs.util.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@EnableAutoConfiguration
//@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private RoleService roleService;

    //    使用默认
    private final Logger log= LoggerFactory.getLogger(AdminController.class);


    @GetMapping({"adminlogin","admin"})
    String login(Model model) {
        model.addAttribute("adminUser", new User());
        return "adminlogin";
    }


//    登录到管理员
    @RequestMapping(value = "adminUserLogin",method = RequestMethod.POST)
    String adminUserLogin(User user, Model model, HttpSession session){
        boolean hasUser=loginService.login(user,session);
        if (hasUser && userService.isAdmin(session)){
            log.info(SecurityUtils.getUser().getUsername() +"成功登录到管理者界面");
            return "redirect:/admin/admin-manage";
        } else {
            log.info("无法登录");
            model.addAttribute("message", "用户名和密码错误");
            return "redirect:admin/login";
        }
    }

//    管理页面
    @RequestMapping("admin/admin-manage")
    String adminMange(Model model) {
        //            统计总数量
        long adminNum=adminUserService.adminCount();
        long userNum=userService.userCount();
        long productNum=productService.productCount();
        model.addAttribute("adminNum",adminNum );
        model.addAttribute("userNum", userNum);
        model.addAttribute("productNum", productNum);
        return "admin/admin-manage";
    }


    //管理商品信息
    @RequestMapping("admin/product-manage")
    public String productManager(Model model,@PageableDefault(size = 8,
            direction = Sort.Direction.ASC) Pageable pageable) {
//        System.out.print(productService.listProduct(user.getId(),pageable));
        model.addAttribute("page",productService.listProduct(pageable));
        return "admin/product-manage";
    }

    //管理留言信息
    @RequestMapping("admin/comment-manage")
    public String commentManager(Model model,@PageableDefault(size = 8,
            direction = Sort.Direction.ASC) Pageable pageable) {
//        System.out.print(productService.listProduct(user.getId(),pageable));
        model.addAttribute("commentList",commentService.listComment(pageable));
        return "admin/comment-manage";
    }


    //管理留言信息
    @RequestMapping("admin/role-manage")
    public String roleManage(Model model,@PageableDefault(size = 8,
            direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("role",new Role());
        model.addAttribute("roleList",roleService.listRole(pageable));
        return "admin/role-manage";
    }



}
