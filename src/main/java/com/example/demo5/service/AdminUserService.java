package com.example.demo5.service;


import com.example.demo5.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserService {
    @Autowired
    private UserRepository userRepository;

    public long adminCount(){
        return userRepository.count();
    }


}
