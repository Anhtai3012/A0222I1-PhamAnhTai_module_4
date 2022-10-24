package codegym.repository;

import codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
}
