package com.codgym.demo.blogupgrade.service;

import com.codgym.demo.blogupgrade.model.Blog;
import com.codgym.demo.blogupgrade.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();
    Optional<Category> findById(Integer id);
    void save(Blog blog);
    void DeleteById(Integer id);
}
