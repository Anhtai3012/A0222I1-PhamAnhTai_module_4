package com.example.demo.service.impl;

import com.example.demo.model.TypeQuestion;
import com.example.demo.repos.ITypeRepos;
import com.example.demo.service.IDependentQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TypeQuestionService implements IDependentQuestionService<TypeQuestion> {
    @Autowired
    ITypeRepos repos;

    @Override
    public List<TypeQuestion> findAll() {
        return repos.findAll();
    }

    @Override
    public void save(TypeQuestion typeQuestion) {
        repos.save(typeQuestion);
    }

    @PostConstruct
    private void getData() {
        save(new TypeQuestion(1L, "studying"));
        save(new TypeQuestion(2L, "professorial"));
        save(new TypeQuestion(3L, "other"));
    }
}
