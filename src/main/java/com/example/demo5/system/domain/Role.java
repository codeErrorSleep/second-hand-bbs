package com.example.demo5.system.domain;


import javax.persistence.*;
import java.util.Date;

/**
* @Description:    角色类(分辨会员,用户等)
* @Author:         qiuShao
* @CreateDate:     20-6-5 下午10:57
*/
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue
    private Long roleId;

    private String roleName;

    private String remark;

//    标记是那个用户创建的
    private Long userIdCreate;


//    将权限分类标记
    private String roleSign;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getUserIdCreate() {
        return userIdCreate;
    }

    public void setUserIdCreate(Long userIdCreate) {
        this.userIdCreate = userIdCreate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRoleSign() {
        return roleSign;
    }

    public void setRoleSign(String roleSign) {
        this.roleSign = roleSign;
    }
}
