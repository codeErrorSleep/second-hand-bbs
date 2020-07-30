package com.example.demo5.controller;


import com.example.demo5.domain.User;
import com.example.demo5.service.ProductService;
import com.example.demo5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@EnableAutoConfiguration
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @GetMapping("/login")
    String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }




    @GetMapping("/register")
    String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }



    //    路径映射
    @PostMapping("/registerUser")
    String registerUser(User user, Model model) {
        if(userService.registerUser(user)){
            return "login";
        }
        else{
            model.addAttribute("message", "false");
            return "register";
        }
    }


    /**
     *  用户的登录请求
     *@Author: qiuwenhao
     *@date: 2020/7/28
     */
//    @PostMapping("/userLogin")
//    String userLogin(User user, Model model, HttpSession session, @PageableDefault(size = 8, sort = {
//            "createTime"},
//            direction = Sort.Direction.DESC) Pageable pageable){
//        if (userService.login(user,session)) {
//            model.addAttribute("page",productService.listProduct(pageable));
//            return "redirect:/index";
//        } else {
//            model.addAttribute("message", "用户名和密码错误");
//            return "login";
//        }
//    }


    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/index";
    }


}
