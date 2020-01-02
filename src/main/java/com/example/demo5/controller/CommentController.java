package com.example.demo5.controller;


import com.example.demo5.domain.AdminUser;
import com.example.demo5.domain.Comment;
import com.example.demo5.domain.User;
import com.example.demo5.service.CommentService;
import com.example.demo5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private ProductService productService;

    //    上传评论
    @RequestMapping(value = "/comment/{id}",method = RequestMethod.GET)
    String uploadComment(@PathVariable Long id, Comment comment, Model model, HttpSession session){
        comment.setProduct(productService.getAndConvert(id));
        comment.setNickname(((User) session.getAttribute("user")).getUsername());
        commentService.saveComment(comment);
        return "redirect:/product/"+id.toString();
    }



    //删除商品信息
    @RequestMapping("/comment/delete/{id}")
    public String commentDelete(@PathVariable Long id,Model model,HttpSession session) {
//        删除商品信息 boolean
        if(commentService.deleteComment(id)){
            model.addAttribute("message","成功删除商品");
        }else{
            model.addAttribute("message","删除商品失败");
        }
//        判断删除产品的的是管理员还是用户
        if (session.getAttribute("user")!=null){
            return "redirect:/comment-manage";
        }
        else{
            return "redirect:/admin/comment-manage";
        }

    }



    //普通用户管理留言信息
    @RequestMapping("comment-manage")
    public String commentManager(Model model,HttpSession session,@PageableDefault(size = 8,
            direction = Sort.Direction.ASC) Pageable pageable) {
        Long userid=((User) session.getAttribute("user")).getId();
//        System.out.print(productService.listProduct(user.getId(),pageable));
        model.addAttribute("commentList",commentService.listComment(userid,pageable));
        return "comment-manage";
    }



}
