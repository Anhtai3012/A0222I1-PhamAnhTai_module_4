package com.codegym.test.service.impl;

import com.codegym.test.model.Category;
import com.codegym.test.repository.ICategoryRepository;
import com.codegym.test.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Page<Category> findAllByName(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void removeID(Integer id) {

    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
