package com.example.demo5.service;


import com.example.demo5.dao.UserRepository;
import com.example.demo5.dao.UserRoleReposotory;
import com.example.demo5.domain.User;
import com.example.demo5.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AdminUserService {
    @Autowired
    private UserRepository userRepository;

    public long adminCount(){
        return userRepository.count();
    }


}
