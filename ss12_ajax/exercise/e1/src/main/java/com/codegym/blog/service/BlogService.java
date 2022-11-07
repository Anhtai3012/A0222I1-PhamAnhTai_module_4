package com.codegym.blog.service;


import com.codegym.blog.model.Blog;
import com.codegym.blog.model.User;

public interface BlogService {
    Iterable<Blog> findAll();
    Iterable<Blog> findById(User user);

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);

}
