package com.example.demo5.controller;

import com.example.demo5.domain.Comment;
import com.example.demo5.domain.Product;
import com.example.demo5.domain.User;
import com.example.demo5.service.CommentService;
import com.example.demo5.service.ProductService;
import org.hibernate.annotations.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@EnableAutoConfiguration
public class IndexController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CommentService commentService;

    /**
     * 主页面控制类
     * @author      qiushao
     * @param       [model, session, pageable]
     * @return      java.lang.String
     * @date        20-5-3 下午10:47
     */
    @RequestMapping("/index")
    String index(Model model, HttpSession session,@PageableDefault(size = 8, sort = {"createTime"},
            direction = Sort.Direction.DESC) Pageable pageable) {
//        model.addAttribute("user",session.getAttribute("user"));
        model.addAttribute("user", session.getAttribute("user"));
//        Pageable pageable= PageRequest.of(0, 1);
        model.addAttribute("page",productService.listProduct(pageable));
        return "index";
    }

    /**
     * 返回搜索页面信息
     * @author      qiushao
     * @param       [query, model, session, pageable]
     * @return      java.lang.String
     * @date        20-5-3 下午10:49
     */
    @PostMapping(value = "search")
    String search(@RequestParam String query,Model model, HttpSession session,
                  @PageableDefault(size = 8, direction = Sort.Direction.DESC) Pageable pageable){
        model.addAttribute("page", productService.listProduct("%"+query+"%", pageable));

        return "search";
    }

    /**
     * 主页面的分类显示(对应 化妆类,电脑类等)
     * @author      qiushao
     * @param       [type, model, session, pageable]
     * @return      java.lang.String
     * @date        20-5-3 下午10:50
     */
    @GetMapping(value = "index{type}")
    String indexType(@PathVariable String type,Model model, HttpSession session,
                  @PageableDefault(size = 8, direction = Sort.Direction.DESC) Pageable pageable){
        model.addAttribute("type",type);
        model.addAttribute("page", productService.listProductType(type, pageable));
        return "index";
    }


}
