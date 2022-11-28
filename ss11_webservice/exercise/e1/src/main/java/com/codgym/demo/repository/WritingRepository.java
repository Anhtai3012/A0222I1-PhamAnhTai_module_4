package com.codgym.demo.repository;

import com.codgym.demo.model.Category;

import com.codgym.demo.model.Writing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WritingRepository extends JpaRepository<Writing, Long> {
    Iterable<Writing> findAllByCategory(Category category);
    Page<Writing> findAllByTittleContaining(String tittle, Pageable pageable);
}
