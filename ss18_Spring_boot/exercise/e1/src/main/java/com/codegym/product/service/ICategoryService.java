package com.codegym.product.service;

import com.codegym.product.model.Category;
import com.codegym.product.model.Product;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(Integer id);
    void delete(Category category);
    void save (Category category);
}
