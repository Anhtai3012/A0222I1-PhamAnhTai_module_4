package com.codegym.product.service;

import com.codegym.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Page<Product> findAllByName(String name, Pageable pageable);

    Optional<Product> findById(Long id);

    void save(Product product);

    void removeById(Long id);


}
