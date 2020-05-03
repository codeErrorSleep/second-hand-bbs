package com.example.demo5.controller;


import com.example.demo5.dao.UserRepository;
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
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;


/**
* @Description:    注册与登录的控制类
* @Author:         qiuShao
* @CreateDate:     20-5-3 下午10:07
*/
@Controller
@EnableAutoConfiguration
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;


    /**
     * 返回登录界面
     * @author      qiushao
     * @return      java.lang.String
     * @date        20-5-3 下午10:14
     */
    @RequestMapping("/login")
    String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }



    /**
     * 返回注册界面
     * @author      qiushao
     * @return      java.lang.String
     * @date        20-5-3 下午10:14
     */
    @RequestMapping("/register")
    String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }



    /**
     * 接收注册用户的表单并提交处理
     * @author      qiushao
     * @param       [user, model]
     * @return      java.lang.String
     * @date        20-5-3 下午10:17
     */
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
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
     * 处理提交的注册表单
     * @author      qiushao
     * @param       [a, model, session, pageable]
     * @return      java.lang.String
     * @date        20-5-3 下午10:18
     */
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    String userLogin(User a, Model model, HttpSession session,@PageableDefault(size = 8, sort = {
            "createTime"},
            direction = Sort.Direction.DESC) Pageable pageable){
        User user = userService.checkUser(a.getUsername(),a.getPassword());
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user",user);
            model.addAttribute("page",productService.listProduct(pageable));
            return "redirect:/index";
        } else {
            model.addAttribute("message", "用户名和密码错误");
            return "login";
        }
    }


    /**
     * 返回用户个人页面
     * @author      qiushao
     * @param       [model, session]
     * @return      java.lang.String
     * @exception
     * @date        20-5-3 下午10:28
     */
    @RequestMapping("/user-manage")
    String usermanage(Model model, HttpSession session) {
        model.addAttribute("user", session.getAttribute("user"));
        return "user-manage";
    }

    /**
     * 更新用户信息
     * @author      qiushao
     * @param       [user, model, seesion]
     * @return      java.lang.String
     * @exception
     * @date        20-5-3 下午10:29
     */
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    String updateUser(User user,Model model,HttpSession seesion){
        System.out.print(user.getId());
        System.out.print(user.getEmail());

        return "user-manage";
    }


    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/index";
    }

}
