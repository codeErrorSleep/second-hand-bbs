package com.example.demo5.domain;


import javax.persistence.*;

@Entity
@Table(name = "adminuser")
public class AdminUser {

    @Id
    @GeneratedValue
    private Long id;


    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private int level;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
