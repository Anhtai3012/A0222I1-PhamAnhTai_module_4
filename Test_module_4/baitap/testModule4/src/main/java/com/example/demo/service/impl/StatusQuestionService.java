package com.example.demo.service.impl;

import com.example.demo.model.StatusQuestion;
import com.example.demo.repos.IStatusRepos;
import com.example.demo.service.IDependentQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class StatusQuestionService implements IDependentQuestionService<StatusQuestion> {
    @Autowired
    IStatusRepos statusRepos;

    @Override
    public List<StatusQuestion> findAll() {
        return statusRepos.findAll();
    }

    @Override
    public void save(StatusQuestion statusQuestion) {
        statusRepos.save(statusQuestion);
    }

    @PostConstruct
    private void getData() {
        save(new StatusQuestion(1L, "incomplete"));
        save(new StatusQuestion(2L, "accomplished"));
    }
}
