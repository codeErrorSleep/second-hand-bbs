package com.example.demo5.service;

import com.example.demo5.dao.ProductRepository;
import com.example.demo5.domain.Product;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
* @Description:    商品的服务类
* @Author:         qiuShao
* @CreateDate:     20-5-3 下午11:05
*/
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    /**
    * 保存商品信息
    * @author      qiushao
    * @param       product
    * @return      product
    * @date        20-5-3 下午11:05
    */
    public Product saveProduct(Product product) {
        product.setCreateTime(new Date());
        return productRepository.save(product);
    }


    /**************************针对不同场景下对商品列表的读取*********************************************/
    /**
    * 直接获取商品列表
    * @author      qiushao
    * @date        20-5-3 下午10:00
    */
    public Page<Product> listProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
    /**
     * 按用户来获取商品信息
     * @author      qiushao
     * @date        20-5-3 下午10:00
     */
    public Page<Product> listProduct(Long userId,Pageable pageable) {
        return productRepository.findByUserId(userId,pageable);
    }

    /**
     *  分页获取最新的商品信息
     * @author      qiushao
     * @date        20-5-3 下午10:00
     */
    public Page<Product> listProduct(String query,Pageable pageable) {
        return productRepository.findByQuery(query,pageable);
    }

    /**
     *  分页获取需要的分类
     * @author      qiushao
     * @date        20-5-3 下午10:00
     */
    public Page<Product> listProductType(String type,Pageable pageable) {
        return productRepository.findByType(type,pageable);
    }
    /***********************************************************************************************/




    /**
    * 删除商品信息
    * @author      qiushao
    * @param       id
    * @return      boolean
    * @date        20-5-3 下午11:07
    */
    public boolean deleteProduct(Long id){
        try {
            productRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }finally {
            return true;
        }
    }


    /**
     * 获取单个物品详细信息
     * @author      qiushao
     * @param       [id]
     * @return      com.example.demo5.domain.Product
     * @date        20-5-3 下午11:08
     */
    @Transactional
    public Product getAndConvert(Long id) {
        Product p = productRepository.getOne(id);
        return p;
    }

    /**
    * 统计总人数
    * @author      qiushao
    * @return      long
    * @date        20-5-3 下午11:09
    */
    public long productCount(){
        return productRepository.count();
    }

}
