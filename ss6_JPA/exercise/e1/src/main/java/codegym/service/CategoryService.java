package codegym.service;

import codegym.model.Category;
import codegym.repository.CategoryRepository;

import java.util.List;

public interface CategoryService  {
    List<Category> findAll();

    Category findById(int id);

    void save(Category category);

    void remove(Integer id);
}
