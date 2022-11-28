package com.codegym.test.service;

import com.codegym.test.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IBaseService<Product> {
    Page<Product> findAllTwoField(String content, String title, Pageable pageable);
}
