package com.example.demo5.system.service;


import com.example.demo5.system.dao.AdminRepository;
import com.example.demo5.system.domain.AdminUser;
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
