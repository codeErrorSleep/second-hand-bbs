package com.example.demo5.service;


import com.example.demo5.dao.UserRepository;
import com.example.demo5.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     *  用户在登录的时候传入的用户名，根据用户名去查询用户信息（查出来之后，系统会自动进行密码比对）
     *@Author: qiuwenhao
     *@date: 2020/7/30
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }


//    判断是否能够注册
    public boolean registerUser(User user) {
//        判断用户名是否已经被存在
        if (userRepository.findByUsername(user.getUsername()).isEmpty()) {
            return saveUser(user);
        }
        return false;
    }

    /**
     *  注册保存用户信息
     *@Author: qiuwenhao
     *@date: 2020/7/28
     */
    private boolean saveUser(User user){

        Date date=new Date();
//            保存用户信息
        user.setCreateTime(date);
        userRepository.save(user);
        return true;
    }



    /**
     *  用户登录
     *@Author: qiuwenhao
     *@date: 2020/7/28
     */
    public Boolean login(User user,HttpSession session) {
        user = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (user!=null){
//                不暴露用户密码
            user.setPassword(null);
            session.setAttribute("user",user);
            return true;
        }
        return  false;
    }

    /**
     *  判断当前用户是否是管理者
     *@Author: qiuwenhao
     *@date: 2020/7/28
     */
    public Boolean isAdmin(HttpSession session){
        Long isadmin=(Long) session.getAttribute("role");
        if (isadmin!=2){
            return true;
        }
        return false;

    }


//    统计总人数
    public long userCount(){
        return userRepository.count();
    }

}
