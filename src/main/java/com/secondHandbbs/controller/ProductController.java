package com.secondHandbbs.controller;

import com.secondHandbbs.domain.Comment;
import com.secondHandbbs.domain.Product;
import com.secondHandbbs.domain.User;
import com.secondHandbbs.service.CommentService;
import com.secondHandbbs.service.ProductService;
import com.secondHandbbs.util.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class ProductController {


    @Autowired
    private ProductService productService;

    @Autowired
    private CommentService commentService;

    @Value("${web.upload-path}")
    private String path;

    //    使用默认
    private final Logger log= LoggerFactory.getLogger(ProductController.class);

    @RequestMapping("/product-input")
    public String productionInput(Model model,HttpSession session) {
        model.addAttribute("product", new Product());
        model.addAttribute("user", SecurityUtils.getUser());
        return "product/product-input";
    }

//商品管理界面
    @RequestMapping("user/product-manage")
    public String productManager(Model model,HttpSession session,@PageableDefault(size = 8,
            direction = Sort.Direction.DESC) Pageable pageable) {
        User user= SecurityUtils.getUser();
        model.addAttribute("page",productService.listProduct(user.getId(),pageable));
        return "user/product-manage";
    }

    /**
     * @Description: 删除商品信息
     * @Param: [id, model, session, pageable]
     * @Return: java.lang.String
     * @Author: qiuwenhao
     * @date: 2020/8/10
     */
    @RequestMapping("/product/delete/{id}")
    public String productDelete(@PathVariable Long id,Model model,HttpSession session,
                           @PageableDefault(size = 8,
            direction = Sort.Direction.DESC) Pageable pageable) {
//        删除商品信息 boolean
        if(productService.deleteProduct(id)){
            model.addAttribute("message","成功删除商品");
        }else{
            model.addAttribute("message","删除商品失败");
        }
//      根据用户角色的不同返回不同的页面
        if (session.getAttribute("user")!=null){
            return "redirect:/user/product-manage";
        }
        else{
            return "redirect:/admin/product-manage";
        }

    }


    @GetMapping("/product/update/{id}")
    public String productUpdateUrl(@PathVariable Long id,Model model,HttpSession session) {
        Product product=productService.getAndConvert(id);
        log.info("更新前"+product.toString());

        model.addAttribute("product",product);
        model.addAttribute("user", SecurityUtils.getUser());
        return "product/product-update";

    }

    /**
     * @Description: 更新商品信息
     * @Param: [product, model, session]
     * @Return: java.lang.String
     * @Author: qiuwenhao
     * @date: 2020/8/10
     */
    @PostMapping("/product/update/{id}")
    public String updateProduct(Product product) throws IllegalStateException{
//        保存上传信息
        productService.saveProduct(product);
        log.info("更新商品信息成功:"+product.toString());
        return "redirect:/user/product-manage";
    }


    /**
     * @Description: 上传新的商品信息
     * @Param: [product, files, model, session, pageable]
     * @Return: java.lang.String
     * @Author: qiuwenhao
     * @date: 2020/8/10
     */
    @PostMapping("/saveProduct")
    public String saveProduct(Product product,
                                @RequestParam("files") MultipartFile[] files,
                                Model model, HttpSession session,
                                @PageableDefault(size = 8, sort = {"createTime"}, direction = Sort.Direction.DESC) Pageable pageable)
            throws IllegalStateException, IOException{
        try{
            productService.saveProduct(product,files,session);
        }catch (Exception e){
            log.error(e.toString());
        }
        log.info("保存商品信息成功");
        model.addAttribute("page",productService.listProduct(pageable));
        return "redirect:/index";
    }






    /**
     * @Description: 返回商品页面
     * @Param: [id, model]
     * @Return: java.lang.String
     * @Author: qiuwenhao
     * @date: 2020/8/11
     */
    @GetMapping("/product/{id}")
    public String product(@PathVariable Long id, Model model) {
        Product p=productService.getAndConvert(id);

//        获取同类推荐
        List<Product> listProducts=productService.listProduct(p);
        listProducts.forEach(
                item->{ log.info("同类推荐商品:"+item.toString()); });
        model.addAttribute("listProducts",listProducts);

//        测试添加留言
        List<Comment> commentList=commentService.listCommentByProductId(id);
        if (commentList.size()!=0){
            model.addAttribute("commentList",commentList);
        }
//        计算商品图片便于处理
        int imglength=p.getImgs().size();
        model.addAttribute("user", SecurityUtils.getUser());
        model.addAttribute("imglength",imglength);
        model.addAttribute("product",p);
//        添加一个空的评论实体
        model.addAttribute("comment",new Comment());

        return "product/product";
    }


}
