package com.example.demo5.service;

import com.example.demo5.dao.CommentRepository;
import com.example.demo5.domain.Comment;
import com.example.demo5.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @Description:    评论服务类
* @Author:         qiuShao
* @CreateDate:     20-5-4 上午10:20
*/
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


    /**
    * 分页获取最新的商品信息
    * @author      qiushao
    * @param       pageable
    * @return      Page<Comment>
    * @date        20-5-4 上午10:20
    */
    public Page<Comment> listComment(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    /**
     * 分页获取最新的商品信息
     * @author      qiushao
     * @param       pageable
     * @return      Page<Comment>
     * @date        20-5-4 上午10:20
     */
    public Page<Comment> listComment(Long id,Pageable pageable) {
        return commentRepository.findByUserId(id,pageable);
    }



    /**
    * 删除留言信息
    * @author      qiushao
    * @param       id
    * @return      boolean
    * @date        20-5-4 上午10:21
    */
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
