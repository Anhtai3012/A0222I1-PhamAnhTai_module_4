package com.codgym.demo.service;


import com.codgym.demo.model.Category;
import com.codgym.demo.model.Writing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WritingService {
    Page<Writing> findAll(Pageable pageable);
    Iterable<Writing> findAllNoSort();
    Writing findById(Long id);
    void save(Writing writing);
    void remove(Long id);
    Iterable<Writing> findAllByCategory(Category category);
    Page<Writing> findAllByTittleContaining(String tittle, Pageable pageable);
}