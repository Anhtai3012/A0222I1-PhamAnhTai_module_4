package com.codegym.product.service;

import com.codegym.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Integer id);
    void delete(Integer id);
    void save(Product product);
    Page<Product> getAll(Pageable pageable);
}
