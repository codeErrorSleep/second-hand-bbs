package com.example.demo5;

import com.example.demo5.dao.RoleRepository;
import com.example.demo5.dao.UserRepository;
import com.example.demo5.domain.Role;
import com.example.demo5.domain.User;
import com.example.demo5.util.SecurityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo5ApplicationTests {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads() {

        System.out.println(SecurityUtils.getUser());
    }




}
