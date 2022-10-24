package com.codegym.product.service.impl;

import com.codegym.product.model.Product;
import com.codegym.product.repository.IProductRepository;
import com.codegym.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository repository;

    @Override
    public Page<Product> findAllByName(String name, Pageable pageable) {
        return repository.findAllByName(name,pageable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        assert repository.findById(id).isPresent();
        return repository.findById(id);
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public void removeById(Long id) {
        repository.deleteById(id);
    }


}
