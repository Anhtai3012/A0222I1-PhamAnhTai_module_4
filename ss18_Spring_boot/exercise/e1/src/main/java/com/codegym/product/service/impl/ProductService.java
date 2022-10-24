package com.codegym.product.service.impl;

import com.codegym.product.model.Product;
import com.codegym.product.repository.ProductRepository;
import com.codegym.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository blogRepository;
    @Override
    public List<Product> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void save(Product product) {
        blogRepository.save(product);
    }

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }
}
