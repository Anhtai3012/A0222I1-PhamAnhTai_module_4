package com.codgym.demo.blogupgrade.service.impl;

import com.codgym.demo.blogupgrade.model.Blog;
import com.codgym.demo.blogupgrade.repository.BlogRepository;
import com.codgym.demo.blogupgrade.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BlogService implements IBlogService {

    @Autowired
     private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return blogRepository.findById(Long.valueOf(id));
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void DeleteById(Integer id) {
        blogRepository.deleteById(Long.valueOf(id));
    }
}
