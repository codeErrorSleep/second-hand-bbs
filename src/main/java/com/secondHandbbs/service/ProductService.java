package com.secondHandbbs.service;

import com.secondHandbbs.dao.ProductRepository;
import com.secondHandbbs.domain.Product;
import com.secondHandbbs.domain.User;
import com.secondHandbbs.util.FileUtils;
import com.secondHandbbs.util.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
//    相册保存位置
    @Value("${web.upload-path}")
    private String path;

    //    使用默认
    private final Logger log= LoggerFactory.getLogger(ProductService.class);


    /**
     * @Description: 保存用户信息
     * @Param: product
     * @Return: product
     * @Author: qiuwenhao
     * @date: 2020/8/10
     */
    public Product saveProduct(Product product) {
        product=updateProductInfo(product);
        return productRepository.save(product);
    }


    /**
     * @Description: 对Product实体进行局部更新处理(因为jpa缺少局部更新的功能),
     *               所以在外层进行判断在进行更新,后续应该改换成mybatis,
     * @Param: newProduct:用户输入的数据,需要返回
     * @Return: Product
     * @Author: qiuwenhao
     * @date: 2020/8/10
     */
    private Product updateProductInfo(Product newProduct){
//        获取在数据库当中的数据
        Product p=productRepository.getOne(newProduct.getId());
        if (p.getImgs()!=null){
            newProduct.setImgs(p.getImgs());
        }
        if(p.getComments()!=null){
            newProduct.setComments(p.getComments());
        }
        newProduct.setCreateTime(new Date());
        newProduct.setUser(SecurityUtils.getUser());
        return newProduct;
    }
    
    
//    分页获取最新的商品信息
    public Page<Product> listProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    //    分页获取最新的商品信息
    public Page<Product> listProduct(Long userId,Pageable pageable) {
        return productRepository.findByUserId(userId,pageable);
    }

    //    分页获取最新的商品信息
    public Page<Product> listProduct(String query,Pageable pageable) {
        return productRepository.findByQuery(query,pageable);
    }

    public List<Product> listProduct(Product p){
        return productRepository.findByTitleAndType(p.getTitle(),p.getType());
    }

    //    分页获取需要的分类
    public Page<Product> listProductType(String type,Pageable pageable) {
        return productRepository.findByType(type,pageable);
    }

    public boolean deleteProduct(Long id){
        try {
            productRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }finally {
            return true;
        }
    }


//    获取单个物品详细信息
    @Transactional
    public Product getAndConvert(Long id) {
        Product p = productRepository.getOne(id);
        return p;
    }

    //    统计总人数
    public long productCount(){
        return productRepository.count();
    }

    /**
     *  保存商品信息
     *@Author: qiuwenhao
     *@date: 2020/7/29
     */
    public boolean saveProduct(Product product, MultipartFile[] files, HttpSession session)
            throws IllegalStateException, IOException{
        product.setUser(SecurityUtils.getUser());
        List<String> imgs=saveImgs(product,files);
        product.setImgs(imgs);
        product.setCreateTime(new Date());
        productRepository.save(product);

        return true;
    }


    /**
     *  保存商品的图片
     *@Author: qiuwenhao
     *@date: 2020/7/29
     */
    public List<String> saveImgs(Product product, MultipartFile[] files) throws IllegalStateException, IOException {
        //        保存图片文件
        List<String> imgs= new ArrayList();
        if (null != files && files.length > 0) {
//            文件夹完整的路径
//            类似于 "E://log/secondhand-bbs/productImgs/1/二手洗面奶
            String completePath=path+ File.separator
                                + "productsImgs"+File.separator
                                + product.getUser().getId()+ File.separator
                                +product.getTitle();
//            存入数据库是的路径
//            类似于 "productImgs/1/二手洗面奶
            String dataPath="productsImgs"+File.separator
                            +product.getUser().getId()+ File.separator
                            +product.getTitle();
            for (MultipartFile file : files) {
//                保存文件
                if (file.getSize()!=0){
//                    拼接一个文件路径出来 用户id/商品名称/图片名称
//                    使用File.separator是为了解决Linux和Windows上的路径差异
                    imgs.add(dataPath+File.separator+file.getOriginalFilename());
                    FileUtils.saveFile(file,completePath);
                }
            }
        }

        return imgs;
    }


}
