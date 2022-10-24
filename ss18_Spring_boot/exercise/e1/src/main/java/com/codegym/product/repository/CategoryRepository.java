package com.codegym.product.repository;

import com.codegym.product.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
