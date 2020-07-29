package com.example.demo5;

import com.example.demo5.dao.RoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo5ApplicationTests {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    @Transactional
    public void contextLoads() {
        Long a=new Long(35);
//        roleRepository.deleteById(35);
    }

}
