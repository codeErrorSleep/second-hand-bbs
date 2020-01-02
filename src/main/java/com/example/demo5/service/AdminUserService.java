package com.example.demo5.service;


import com.example.demo5.dao.AdminRepository;
import com.example.demo5.domain.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserService {
    @Autowired
    private AdminRepository adminRepository;

    public AdminUser checkUser(String username, String password) {
        AdminUser adminUser = adminRepository.findByUsernameAndPassword(username, password);

        return adminUser;
    }

    public long adminCount(){
        return adminRepository.count();
    }


}
