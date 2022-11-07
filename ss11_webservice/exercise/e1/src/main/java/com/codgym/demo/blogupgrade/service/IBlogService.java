package com.codgym.demo.blogupgrade.service;

import com.codgym.demo.blogupgrade.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();
    Optional<Blog> findById(Integer id);
    void save(Blog blog);
    void DeleteById(Integer id);
}
