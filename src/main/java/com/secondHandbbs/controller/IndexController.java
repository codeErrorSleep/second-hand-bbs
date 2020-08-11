package com.secondHandbbs.controller;


import com.secondHandbbs.service.CommentService;
import com.secondHandbbs.service.ProductService;
import com.secondHandbbs.util.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;


@Controller
@EnableAutoConfiguration
public class IndexController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CommentService commentService;
//    使用默认
    private final Logger log= LoggerFactory.getLogger(IndexController.class);

//    主页控制
    @GetMapping({"/","/index"})
    String index(Model model,@PageableDefault(size = 16, sort = {"createTime"},
            direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("user", SecurityUtils.getUser());
        model.addAttribute("isAdmin",SecurityUtils.isAdmin());
        model.addAttribute("page",productService.listProduct(pageable));

        if (SecurityUtils.getUser()!=null){
            log.info("当前用户为" + SecurityUtils.getUser().toString());
            log.info("测试当前用户是否为管理员"+SecurityUtils.isAdmin());
        }



        return "index";
    }


    /**
     * @Description: 搜索用品
     * @Param: [query, model, pageable]
     * @Return: java.lang.String
     * @Author: qiuwenhao
     * @date: 2020/8/11
     */
    @PostMapping("/search")
    String search(@RequestParam String query,Model model,
                  @PageableDefault(size = 8, direction = Sort.Direction.DESC) Pageable pageable){
        if ("".equals(query)){
            return "/index";
        }
        model.addAttribute("page", productService.listProduct("%"+query+"%", pageable));
        return "/product/search";
    }

    //主页中不同的物品分类
    @GetMapping(value = "index/{type}")
    String indexType(@PathVariable String type,Model model,
                  @PageableDefault(size = 8, direction = Sort.Direction.DESC) Pageable pageable){
        model.addAttribute("type",type);
        model.addAttribute("page", productService.listProductType(type, pageable));
        return "index";
    }



}
