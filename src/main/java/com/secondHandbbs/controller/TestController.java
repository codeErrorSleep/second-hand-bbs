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
public class TestController {

    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private ProductService productService;
    //    使用默认
    private final Logger log= LoggerFactory.getLogger(TestController.class);



    @GetMapping("/test")
    String test(Model model) {
        return "test";
    }



}
