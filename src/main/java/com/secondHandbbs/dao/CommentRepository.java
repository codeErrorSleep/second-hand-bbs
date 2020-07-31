package com.secondHandbbs.dao;

import com.secondHandbbs.domain.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository  extends JpaRepository<Comment,Long> {
    List<Comment> findByProductId(Long productId);

    @Query(value = "SELECT  c.content,c.create_time,c.nickname,c.id,c.product_id FROM comment c,product p " +
            "WHERE p.user_id = ?1 And p.id=c" +
            ".product_id", nativeQuery = true)
    Page<Comment> findByUserId(Long userid, Pageable pageable);
}
