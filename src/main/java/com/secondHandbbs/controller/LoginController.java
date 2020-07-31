package com.secondHandbbs.controller;


import com.secondHandbbs.domain.User;
import com.secondHandbbs.service.ProductService;
import com.secondHandbbs.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@EnableAutoConfiguration
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    //    使用默认
    private final Logger log= LoggerFactory.getLogger(LoginController.class);


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
        log.info("准备注册用户信息"+user.getUsername());
        if(userService.registerUser(user)){
            log.info("成功注册用户信息"+user.getUsername());
            return "login";
        }
        else{
            log.info("注册用户失败"+user.getUsername());
            model.addAttribute("message", "false");
            return "register";
        }
    }


    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/index";
    }


}
