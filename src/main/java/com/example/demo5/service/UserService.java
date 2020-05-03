package com.example.demo5.service;


import com.example.demo5.dao.UserRepository;
import com.example.demo5.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
    * 判断是否能够注册
    * @author      qiushao
    * @param       user
    * @return      boolean
    * @date        20-5-3 下午10:32
    */
    public boolean registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isEmpty()) {
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }


    /**
    * 判断是否能够登录
    * @author      qiushao
    * @param       username,password
    * @return       user
    * @date        20-5-3 下午10:33
    */
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        return user;
    }

//    统计总人数
    public long userCount(){
        return userRepository.count();
    }

}
