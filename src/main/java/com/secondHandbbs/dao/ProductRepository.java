package com.secondHandbbs.dao;

import com.secondHandbbs.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>,
        PagingAndSortingRepository<Product, Long> {

//    List<Product>findTop30byId(Long Id);
    Page<Product> findByType(String type,Pageable pageable);


    List<Product> findByTitle(String title);

    Page<Product> findByUserId(Long userId, Pageable pageable);

    @Query(value = "SELECT * FROM product AS p " +
            ",product_imgs" +
            " AS s " +
            "WHERE" +
            " p.title LIKE ?1 OR p.content LIKE ?1 ", nativeQuery = true)
    Page<Product> findByQuery(String query, Pageable pageable);

    @Query(value = "SELECT * FROM db_second_hand_bbs.product where title like ?1 or type=?2 order by create_time desc LIMIT 3",nativeQuery = true)
    List<Product> findByTitleAndType(String title,String type);

}
