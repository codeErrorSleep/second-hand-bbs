package com.secondHandbbs;

import com.secondHandbbs.dao.RoleRepository;
import com.secondHandbbs.dao.UserRepository;
import com.secondHandbbs.domain.Role;
import com.secondHandbbs.domain.User;
import com.secondHandbbs.util.SecurityUtils;
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
    @Transactional
    @Rollback(value = false)
    public void contextLoads() {

        User user=new User();
        Role role=roleRepository.getOne((long) 2);
        Set<Role> roles=new HashSet<Role>();
        roles.add(role);
        user.setRoles(roles);
        user.setUsername("aaaa");
        user.setPassword(SecurityUtils.encryptPassword("father"));

        userRepository.save(user);
    }




}
