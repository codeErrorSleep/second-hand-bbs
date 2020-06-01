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

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public Product saveProduct(Product product) {
        product.setCreateTime(new Date());
        return productRepository.save(product);
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

}
