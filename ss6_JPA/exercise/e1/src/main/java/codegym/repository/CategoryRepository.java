package codegym.repository;

import codegym.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
