package com.example.demo5.controller;


import com.example.demo5.dao.UserRepository;
import com.example.demo5.domain.User;
import com.example.demo5.service.ProductService;
import com.example.demo5.service.UserService;
import com.example.demo5.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//import javax.jws.WebParam;
import javax.servlet.http.HttpSession;

@Controller
@EnableAutoConfiguration
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;


    //    主页控制
    @RequestMapping("/user-manage")
    String usermanage(Model model) {
        model.addAttribute("user", SecurityUtils.getUser());
        return "user-manage";
    }


//更新用户信息
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    String updateUser(User user){
        System.out.print(user.getId());
        System.out.print(user.getEmail());
        return "user-manage";
    }




}
