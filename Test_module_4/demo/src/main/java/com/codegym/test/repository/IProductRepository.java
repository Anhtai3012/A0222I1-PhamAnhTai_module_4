package com.codegym.test.repository;

import com.codegym.test.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product p where p.content like concat('%',:content,'%') and p.title like concat ('%',:title,'%')",
            nativeQuery = true ,
            countQuery = "select count(*) from (select * from product p where p.content like concat('%',:content,'%') and p.title like concat ('%',:title,'%') ) product")
    Page<Product> findAllTwoField(@Param("content") String content,@Param("title") String title ,Pageable page);

    @Query(value = "select * from product p where p.content like concat('%',:content,'%')",
            nativeQuery = true ,
            countQuery = "select count(*) from (select * from product p where p.content like concat('%',:content,'%')) product")
    Page<Product> findAllByName(@Param("content") String content,Pageable page);
}
