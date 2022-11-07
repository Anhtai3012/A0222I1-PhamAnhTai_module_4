package com.codgym.demo.blogupgrade.repository;


import com.codgym.demo.blogupgrade.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
