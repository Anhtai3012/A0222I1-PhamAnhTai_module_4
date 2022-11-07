package com.codegym.picture_update.repository;

import com.codegym.picture_update.model.Comment;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@Transactional
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    void update(Integer c);
}
