package com.example.demo5.controller;

import com.example.demo5.dao.UserRepository;
import com.example.demo5.domain.AdminUser;
import com.example.demo5.service.AdminUserService;
import com.example.demo5.service.CommentService;
import com.example.demo5.service.ProductService;
import com.example.demo5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@EnableAutoConfiguration
public class AdminController {

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("admin/login")
    String login(Model model) {
        model.addAttribute("adminUser", new AdminUser());
        return "admin/login";
    }


//    登录到管理员
    @RequestMapping(value = "admin/adminUserLogin",method = RequestMethod.POST)
    String adminUserLogin(AdminUser a, Model model, HttpSession session){
        AdminUser adminuser = adminUserService.checkUser(a.getUsername(),a.getPassword());
        if (adminuser != null) {
            adminuser.setPassword(null);
            session.setAttribute("adminuser",adminuser);

            return "redirect:/admin/admin-manage";
        } else {
            model.addAttribute("message", "用户名和密码错误");
            return "admin/login";
        }
    }

//    管理页面
    @RequestMapping("admin/admin-manage")
    String adminMange(Model model, HttpSession session) {
//没登录是访问返回到登录界面
        if(session.getAttribute("adminuser")==null){
            model.addAttribute("adminUser", new AdminUser());
            return "admin/login";
        }
        //            统计总数量
        long adminNum=adminUserService.adminCount();
        long userNum=userService.userCount();
        long productNum=productService.productCount();
        model.addAttribute("adminNum",adminNum );
        model.addAttribute("userNum", userNum);
        model.addAttribute("productNum", productNum);


//        System.out.print(session.getAttribute("adminuser"));
        return "admin/admin-manage";
    }


    //管理商品信息
    @RequestMapping("admin/product-manage")
    public String productManager(Model model,HttpSession session,@PageableDefault(size = 8,
            direction = Sort.Direction.ASC) Pageable pageable) {
//        System.out.print(productService.listProduct(user.getId(),pageable));
        model.addAttribute("page",productService.listProduct(pageable));
        return "admin/product-manage";
    }

    //管理留言信息
    @RequestMapping("admin/comment-manage")
    public String commentManager(Model model,HttpSession session,@PageableDefault(size = 8,
            direction = Sort.Direction.ASC) Pageable pageable) {
//        System.out.print(productService.listProduct(user.getId(),pageable));
        model.addAttribute("commentList",commentService.listComment(pageable));
        return "admin/comment-manage";
    }




}
