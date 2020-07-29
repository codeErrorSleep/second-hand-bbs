package com.example.demo5.controller;

import com.example.demo5.domain.Comment;
import com.example.demo5.domain.Product;
import com.example.demo5.domain.User;
import com.example.demo5.service.CommentService;
import com.example.demo5.service.ProductService;
import com.example.demo5.util.FileUtils;
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
import java.util.ArrayList;
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

    @RequestMapping("/product-input")
    public String productionInput(Model model,HttpSession session) {
        model.addAttribute("product", new Product());
        model.addAttribute("user", session.getAttribute("user"));
        return "product-input";
    }

//商品管理界面
    @RequestMapping("product-manage")
    public String productManager(Model model,HttpSession session,@PageableDefault(size = 8,
            direction = Sort.Direction.DESC) Pageable pageable) {
        User user=((User) session.getAttribute("user"));
//        System.out.print(productService.listProduct(user.getId(),pageable));
        model.addAttribute("page",productService.listProduct(user.getId(),pageable));
        return "product-manage";
    }

//删除商品信息
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
            return "redirect:/product-manage";
        }
        else{
            return "redirect:/admin/admin/product-manage";
        }

    }

    //修改商品信息页面
    @RequestMapping("/product/update/{id}")
    public String productUpdate(@PathVariable Long id,Model model,HttpSession session) {
        Product product=productService.getAndConvert(id);
        model.addAttribute("product",product);
        User user=((User) session.getAttribute("user"));
//        model.addAttribute("page",productService.listProduct(user.getId(),pageable));
        return "product-update";

    }

    //    修改商品信息操作
    @RequestMapping(value = "/product/update/{id}", method = RequestMethod.POST)
    public String updateProduct(Product product,Model model,
                                HttpSession session) throws IllegalStateException{
//        保存上传信息
        Product p;
        p=productService.saveProduct(product);
        return "redirect:/product-manage";
    }


    //   上传商品信息
    @RequestMapping(value = "/uploadProduct", method = RequestMethod.POST)
    public String uploadProduct(Product product,
                                @RequestParam("files") MultipartFile[] files,
                                Model model, HttpSession session,@PageableDefault(size = 8, sort = {"createTime"},
            direction = Sort.Direction.DESC) Pageable pageable) throws IllegalStateException, IOException{

        product.setUser((User) session.getAttribute("user"));
//        保存图片文件
        List<String> imgs= new ArrayList();
        if (null != files && files.length > 0) {
            for (MultipartFile file : files) {
                // 测试MultipartFile接口的各个方法
//                System.out.println("文件原名称OriginalFileName=" + file.getOriginalFilename());
//                System.out.println("文件大小Size=" + file.getSize() + "byte or " + file.getSize() / 1024 + "KB");
//                保存文件
                if (file.getSize()!=0){
                    imgs.add(product.getTitle()+"/"+file.getOriginalFilename());
                    FileUtils.saveFile(file,path,product.getTitle());
                    System.out.print(path+"/"+file.getOriginalFilename());
                }
            }

        }
        product.setImgs(imgs);
//        保存上传信息
        Product p;
        p=productService.saveProduct(product);
        model.addAttribute("page",productService.listProduct(pageable));
        return "index";
    }


//获取商品详细信息
    @RequestMapping("/product/{id}")
    public String product(@PathVariable Long id, Model model) {
        Product p=productService.getAndConvert(id);

//        测试添加留言
        List<Comment> commentList=commentService.listCommentByProductId(id);
        if (commentList.size()!=0){
            model.addAttribute("commentList",commentList);
        }
//        计算商品图片便于处理
        int imglength=p.getImgs().size();
        model.addAttribute("imglength",imglength);
        model.addAttribute("product",p);
//        添加一个空的评论实体
        model.addAttribute("comment",new Comment());

        return "product";
    }


}
