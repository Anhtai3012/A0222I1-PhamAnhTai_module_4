package com.codegym.picture_update.repository;

import com.codegym.picture_update.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    void update(Integer c);
}
