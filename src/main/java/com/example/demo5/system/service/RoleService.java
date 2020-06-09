package com.example.demo5.system.service;

import com.example.demo5.domain.Product;
import com.example.demo5.system.dao.RoleRepository;
import com.example.demo5.system.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

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


    public boolean addRole(Role role){
        if (roleRepository.findByRoleName(role.getRoleName()).isEmpty()) {
            role.setCreateTime(new Date());
            roleRepository.save(role);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateRole(Role role){
        role.setCreateTime(new Date());
        roleRepository.save(role);
        return true;
    }


    public boolean deleteRole(Long roleId){
        try {
            System.out.println(roleId.getClass().getName());
            System.out.println(roleId);


            roleRepository.deleteByRoleId(roleId);


        }catch (Exception e){
            return false;
        }finally {
            return true;
        }
    }


}
