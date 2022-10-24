package codegym.service.impl;

import codegym.model.Blog;
import codegym.model.Category;
import codegym.repository.IBlogRepository;
import codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private IBlogRepository blogRepository;
//    @Override
//    public Page<Blog> findAll(Pageable pageable) {
//        return blogRepository.findAll((org.springframework.data.domain.Pageable) pageable);
//    }


    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }
}
