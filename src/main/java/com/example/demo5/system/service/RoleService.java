package com.example.demo5.system.service;

import com.example.demo5.domain.Product;
import com.example.demo5.system.dao.RoleRepository;
import com.example.demo5.system.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public void listRole() {
        for(Role role:roleRepository.findAll()){
            System.out.println(role.getRoleId());
        }

    }

    //    分页获取最新的商品信息
    public Page<Role> listRole(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }



}
