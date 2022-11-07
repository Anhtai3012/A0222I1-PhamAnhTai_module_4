package com.codegym.blog.service;


import com.codegym.blog.model.User;

public interface UserService {

    Iterable<User> findAll();

    User findById(Long id);

    void save(User user);

    void remove(Long id);
}
