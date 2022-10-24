package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.User;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    List<Blog> findById(User user);

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);
}
