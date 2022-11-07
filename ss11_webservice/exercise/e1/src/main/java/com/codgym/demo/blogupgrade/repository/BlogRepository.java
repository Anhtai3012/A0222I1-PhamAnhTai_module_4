package com.codgym.demo.blogupgrade.repository;

import com.codgym.demo.blogupgrade.model.Blog;
import com.codgym.demo.blogupgrade.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    Iterable<Blog> findAllByCategory(Category category);
    List<Blog> findAllByNameBlogContaining(String search);
}
