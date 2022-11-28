package com.codegym.blog.repository;


import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    Iterable<Blog> findAllByCategory(Category category);

    @Query(value = "select * from blogs b where b.name_blog like concat('%',:name_blog,'%') ",nativeQuery = true)
    List<Blog> SearchName(@Param("name_blog") String search);


    List<Blog> findAllByNameBlogContaining(String search);
//    @Query(value = "select * from Product p where p.name like concat('%',:name,'%') ",
//            nativeQuery = true ,
//            countQuery = "select count('*') from (select * from Product p where p.name like concat('%',:name,'%')) p ")
//    Page<Product> findAllByName(@Param("name")String name, Pageable page);
}
