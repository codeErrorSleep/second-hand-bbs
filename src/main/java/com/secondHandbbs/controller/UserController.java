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
        log.info("当前用户信息"+userService.getUserById(SecurityUtils.getUser().getId()));
        model.addAttribute("user",userService.getUserById(SecurityUtils.getUser().getId()));
        return "/user/user-manage";
    }


    /**
     * @Description: 更新用户对象信息
     * @Param: [user]
     * @Return: java.lang.String
     * @Author: qiuwenhao
     * @date: 2020/8/11
     */
    @PostMapping("/user/updateUser")
    public String updateUser(User user){
        user=userService.updateUesr(user);
        log.info("更新后的user信息:"+user);
        return "redirect:/user/user-manage";
    }




}
