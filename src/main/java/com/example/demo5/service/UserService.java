package com.example.demo5.service;


import com.example.demo5.dao.UserRepository;
import com.example.demo5.dao.UserRoleReposotory;
import com.example.demo5.domain.User;
import com.example.demo5.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesSunMisc;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleReposotory userRoleReposotory;

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
//            保存用户与角色关系信息
//            参数1用户id   2默认角色id     3日期
        UserRole userRole=new UserRole(user.getId(),(long) 2,date);
        userRoleReposotory.save(userRole);
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
            UserRole userRole=userRoleReposotory.findByUserId(user.getId());
            if (userRole.getRoleId()>0){
//                不暴露用户密码
                user.setPassword(null);
                session.setAttribute("user",user);
//                设置用户等级
                session.setAttribute("role",userRole.getRoleId());
                return true;
            }
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
