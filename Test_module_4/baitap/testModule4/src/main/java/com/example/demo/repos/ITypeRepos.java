package com.example.demo.repos;

import com.example.demo.model.TypeQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeRepos extends JpaRepository<TypeQuestion,Long> {
}
