package com.example.demo5.domain;


import com.example.demo5.system.domain.AdminUser;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "announce")
public class Announce {

    @Id
    @GeneratedValue
    private Long id;

    private String content;
    private String title;
    private String type;

    @ManyToOne
    @JoinColumn(name="adminuser_id")
    private AdminUser adminUser;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AdminUser getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(AdminUser adminUser) {
        this.adminUser = adminUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
