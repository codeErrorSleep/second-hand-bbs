package com.secondHandbbs.domain;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "sys_user")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;


    /*与role进行映射*/
    @ManyToMany(targetEntity = Role.class,fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "sys_user_role",
            //joinColumns,当前对象在中间表中的外键
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            //inverseJoinColumns，对方对象在中间表的外键
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    private Set<Role> roles;


    /*accountNonExpired、accountNonLocked、credentialsNonExpired、enabled
    这四个属性分别用来描述用户的状态，表示账户是否没有过期、账户是否没有被锁定、密码是否没有过期、以及账户是否可用。*/
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;


    private String email;
    private String phone;
    private String wechat;

    /*性别*/
    private String sex;
    /*最后登录时间*/
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginTime;
    /*用户创建时间*/
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;


    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    /*getAuthorities 方法返回用户的角色信息，我们在这个方法中把自己的 Role 稍微转化一下即可*/
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }

    /**
     * @Description: 设置所有用户属性
     * @Author: qiuwenhao
     * @date: 2020/8/11
     */
    public void setSecurity(){
        this.setAccountNonExpired(true);
        this.setAccountNonLocked(true);
        this.setCredentialsNonExpired(true);
        this.setEnabled(true);
    }




    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    /**
     *  分辨当前用户是否为管理员
     *@Author: qiuwenhao
     *@date: 2020/7/31
     */
    public boolean isAdmin(){
        for (Role role: roles) {
            if (role.getRoleId()==1){
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * StackOverflowError
     *  返回当前用户所有roles的id和name
     *@Author: qiuwenhao
     *@date: 2020/7/31
     */
    public String getAllRoles(){
        if (roles==null){
            return "null";
        }
        String rolesStr="{";
        for (Role role: roles) {
            rolesStr=rolesStr+role.getRoleId()+" "+role.getRoleName()+",";
        }
        rolesStr=rolesStr+"}";
        return rolesStr;
    }

    /**
     * 添加当个角色
     *@Author: qiuwenhao
     *@date: 2020/7/31
     */
//    public void setRole(Role role){
//        roles.add(role);
//    }

    @Override
    public String toString() {
//        String rolesStr=getAllRoles();
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
//                ", roles=" + rolesStr +
                ", accountNonExpired=" + accountNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", credentialsNonExpired=" + credentialsNonExpired +
                ", enabled=" + enabled +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", wechat='" + wechat + '\'' +
                ", sex='" + sex + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", createTime=" + createTime +
                '}';
    }
}