package com.example.demo5.dao;


import com.example.demo5.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    public List<User> findByUsername(String name);

//    public List<User> findByNameAndPassword(String name,String password);

//    @Query("from User u where u.name=:name")
//    public List<User> findUser(@Param("name") String name);

    User findByUsernameAndPassword(String username, String password);


}
