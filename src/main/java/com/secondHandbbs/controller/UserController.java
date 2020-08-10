package com.secondHandbbs.controller;


import com.secondHandbbs.domain.User;
import com.secondHandbbs.service.ProductService;
import com.secondHandbbs.service.UserService;
import com.secondHandbbs.util.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//import javax.jws.WebParam;


@Controller
@EnableAutoConfiguration
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    private final Logger log= LoggerFactory.getLogger(ProductController.class);

    //    主页控制
    @GetMapping("/user/user-manage")
    public String usermanage(Model model) {
        log.info("当前用户信息"+SecurityUtils.getUser().toString());
        model.addAttribute("user", SecurityUtils.getUser());
        return "/user/user-manage";
    }


//更新用户信息
    @PostMapping("/user/updateUser")
    public String updateUser(User user){

        log.info(user.toString());
//        userService.updateUser(user);
        return "/user/user-manage";
    }




}
