package com.secondHandbbs.controller;


import com.secondHandbbs.domain.User;
import com.secondHandbbs.service.ProductService;
import com.secondHandbbs.service.UserService;
import com.secondHandbbs.util.SecurityUtils;
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


    //    主页控制
    @RequestMapping("/user/user-manage")
    String usermanage(Model model) {
        model.addAttribute("user", SecurityUtils.getUser());
        return "/user/user-manage";
    }


//更新用户信息
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    String updateUser(User user){
        System.out.print(user.getId());
        System.out.print(user.getEmail());
        return "/user/user-manage";
    }




}
