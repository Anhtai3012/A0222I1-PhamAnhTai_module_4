package com.codegym.product.service;

import com.codegym.product.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
