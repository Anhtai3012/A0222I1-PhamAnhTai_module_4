package com.example.demo.service;



import java.util.List;

public interface IDependentQuestionService<E> {
    List<E> findAll();

    void save(E e);
}
