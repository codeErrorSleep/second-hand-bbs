package com.secondHandbbs.dao;

import com.secondHandbbs.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {

    List<Role> findByRoleName(String roleName);


    void deleteByRoleId(Long roleId);


}