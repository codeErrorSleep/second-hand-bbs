package com.example.demo5.dao;

import com.example.demo5.domain.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<AdminUser,Long> {

    public List<AdminUser> findByUsername(String name);

    AdminUser findByUsernameAndPassword(String username, String password);


}
