package com.codegym.product.service.impl;

import com.codegym.product.model.Category;
import com.codegym.product.repository.ICategoryRepository;
import com.codegym.product.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository repository;
    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }
}
