package com.codegym.product.repository;

import com.codegym.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

@Transactional
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
