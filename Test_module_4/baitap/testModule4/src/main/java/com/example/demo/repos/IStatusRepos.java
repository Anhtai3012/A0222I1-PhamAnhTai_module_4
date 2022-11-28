package com.example.demo.repos;

import com.example.demo.model.StatusQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusRepos extends JpaRepository<StatusQuestion, Long> {
}
