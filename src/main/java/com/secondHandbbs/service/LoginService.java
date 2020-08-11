package com.secondHandbbs.service;


import com.secondHandbbs.dao.RoleRepository;
import com.secondHandbbs.dao.UserRepository;
import com.secondHandbbs.domain.Role;
import com.secondHandbbs.domain.User;
import com.secondHandbbs.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
* @Description: 注册登录类
* @Author: qiuwenhao
* @date: 2020/8/11
*/
@Service
public class LoginService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;



    /**
     *  用户登录
     *@Author: qiuwenhao
     *@date: 2020/7/28
     */
    public Boolean login(User user, HttpSession session) {
//        对密码进行加密处理
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
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
     *  注册用户
     *@Author: qiuwenhao
     *@date: 2020/7/31
     */
    public boolean registerUser(User user) {
//        判断用户名是否已经被存在
        if (userRepository.findByUsername(user.getUsername()).isEmpty()) {
            user=setUserInfo(user);
            userRepository.save(user);
            return true;
        }
        return false;
    }


    /**
     *  设置部分用户信息
     *@Author: qiuwenhao
     *@date: 2020/7/31
     */
    private User setUserInfo(User user){
        //            添加用户的默认角色
        Set<Role> roles=new HashSet<Role>();
        roles.add(roleRepository.getOne((long) 2));
        user.setRoles(roles);
//            设置(加密密码)
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
//        设置创建时间
        Date date=new Date();
        user.setCreateTime(date);
        return user;
    }


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




}
