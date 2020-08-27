package com.secondHandbbs.controller;


import com.secondHandbbs.domain.User;
import com.secondHandbbs.service.LoginService;
import com.secondHandbbs.service.ProductService;
import com.secondHandbbs.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@EnableAutoConfiguration
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private ProductService productService;
    //    使用默认
    private final Logger log= LoggerFactory.getLogger(LoginController.class);



    @GetMapping("/login")
    String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }


    @PostMapping("/userLogin")
    @ResponseBody
    String tologin() {
        System.out.println("safdasfdas");
        return "login";
    }





    @GetMapping("/register")
    String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }



    /**
     * @Description: 注册用户
     * @Param: [user, model]
     * @Return: java.lang.String
     * @Author: qiuwenhao
     * @date: 2020/8/11
     */
    @PostMapping("/registerUser")
    String registerUser(User user, Model model) {
        log.info("准备注册用户信息"+user.getUsername());
        if(loginService.registerUser(user)){
            log.info("成功注册用户信息"+user.getUsername());
            return "login";
        }
        else{
            log.info("注册用户失败"+user.getUsername());
            model.addAttribute("message", "false");
            return "register";
        }
    }




}
