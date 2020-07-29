package com.example.demo5.dao;

import com.example.demo5.domain.User;
import com.example.demo5.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleReposotory extends JpaRepository<UserRole,Long> {

    UserRole findByUserId(Long userId);


}
