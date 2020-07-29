package com.example.demo5.dao;

import com.example.demo5.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {

    List<Role> findByRoleName(String roleName);


    void deleteByRoleId(Long roleId);


}