package com.codgym.demo.blogupgrade.service.impl;

import com.codgym.demo.blogupgrade.model.Blog;
import com.codgym.demo.blogupgrade.model.Category;
import com.codgym.demo.blogupgrade.repository.CategoryRepository;
import com.codgym.demo.blogupgrade.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(Long.valueOf(id));
    }

    @Override
    public void save(Blog blog) {

    }

    @Override
    public void DeleteById(Integer id) {

    }
}
