package com.example.demo5.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
*   用户与角色对应的表
*@Author: qiuwenhao
*@date: 2020/7/28
*/
@Entity
@Table(name = "sys_user_role")
public class UserRole {


    @Id
    @GeneratedValue
    private Long id;
    /*对用的用户id*/
    private Long userId;
    /*对应的角色id*/
    private Long roleId;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public UserRole(Long userId,Long roleId,Date date){
        this.setUserId(userId);
        this.setRoleId(roleId);
        this.setCreateTime(date);
    }

    public UserRole(){ }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
