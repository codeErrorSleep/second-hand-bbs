package com.secondHandbbs.domain;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @ManyToOne
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

//    @Override
//    public String toString() {
//        return "Comment{" +
//                "id=" + id +
//                ", nickname='" + nickname + '\'' +
//                ", content='" + content + '\'' +
//                ", createTime=" + createTime +
//                ", product=" + product +
//                '}';
//    }
}
