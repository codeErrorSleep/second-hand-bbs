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
* @Description: 系统用户类
* @Author: qiuwenhao
* @date: 2020/8/11
*/
@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;





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

    /**
     * @Description: 更新用户的个人信息
     * @Param: User
     * @Return: user:返回user对象作参考,方便调试,后期可改为boolean
     * @Author: qiuwenhao
     * @date: 2020/8/10
     */
    public User updateUesr(User user){
        user=updateUserInfo(user);
        userRepository.save(user);
        return user;
    }

    /**
     * @Description: 更新用户的部分信息
     * @Param: User
     * @Return: User
     * @Author: qiuwenhao
     * @date: 2020/8/11
     */
    private User updateUserInfo(User user){
//        获取数据库当中旧的数据,方便更新
        User oldUer=userRepository.getOne(user.getId());
//        判断是否有修改密码
        if(!SecurityUtils.matchesPassword(user.getPassword(),oldUer.getPassword())){
//            如果不一样,需要先加密,再放到数据库当中
            user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
            System.out.println(SecurityUtils.encryptPassword(user.getPassword()));
        }

        user.setSecurity();
        user.setRoles(oldUer.getRoles());
        user.setLastLoginTime(oldUer.getLastLoginTime());
        user.setCreateTime(oldUer.getCreateTime());
        return user;
    }






    /**
     * @Description: 获取单个用户
     * @Param: userId 用户id
     * @Return: User
     * @Author: qiuwenhao
     * @date: 2020/8/11
     */
    public User getUserById(Long userId){
        return userRepository.getOne(userId);
    }

//    统计总人数
    public long userCount(){
        return userRepository.count();
    }

}
