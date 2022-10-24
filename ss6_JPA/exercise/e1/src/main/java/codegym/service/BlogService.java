package codegym.service;

import codegym.model.Blog;
import codegym.model.Category;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface BlogService {

//    Iterable<Blog> findById(Category category);
    List<Blog> findAll();
    Blog findById(int id);

    void save(Blog blog);

    void remove(int id);
}
