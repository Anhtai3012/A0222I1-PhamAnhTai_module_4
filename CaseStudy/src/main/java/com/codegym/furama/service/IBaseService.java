package com.codegym.furama.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBaseService<E> {
    Page<E> findAllByName(String keyword, Pageable pageable);

    Optional<E> findById(Integer id);

    void save(E e);

    void remove(Integer id);

    List<E> findAll();

}
