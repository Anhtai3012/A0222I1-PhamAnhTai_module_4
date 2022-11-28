package com.codegym.test.service.impl;

import com.codegym.test.model.Category;
import com.codegym.test.model.Product;
import com.codegym.test.repository.IProductRepository;
import com.codegym.test.service.ICategoryService;
import com.codegym.test.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> findAllByName(String keyword, Pageable pageable) {
        return productRepository.findAllByName(keyword,pageable);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void removeID(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findAllTwoField(String content, String title, Pageable pageable) {
        return productRepository.findAllTwoField(content,title,pageable);
    }
}
