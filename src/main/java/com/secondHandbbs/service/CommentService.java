package com.secondHandbbs.service;

import com.secondHandbbs.dao.CommentRepository;
import com.secondHandbbs.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> listCommentByProductId(Long productId) {
        List<Comment> comments = commentRepository.findByProductId(productId);
        return comments;
    }

    public Comment saveComment(Comment comment){
        comment.setCreateTime(new Date());
        return commentRepository.save(comment);
    }


    //    分页获取最新的商品信息
    public Page<Comment> listComment(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    //    分页获取最新的商品信息
    public Page<Comment> listComment(Long id,Pageable pageable) {
        return commentRepository.findByUserId(id,pageable);
    }



    //    删除留言信息
    public boolean deleteComment(Long id){
        try {
            commentRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }finally {
            return true;
        }
    }



}
