package com.example.demo.service.impl;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.model.Question;
import com.example.demo.model.StatusQuestion;
import com.example.demo.model.TypeQuestion;
import com.example.demo.repos.IQuestionRepos;
import com.example.demo.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService implements IQuestionService {
    @Autowired
    IQuestionRepos repos;

    @Override
    public Page<Question> findAllByTitleAndType(String title, String type, Pageable pageable) {
        return repos.findAllByTitleAndType(title, type, pageable);
    }

    @Override
    public Question save(Question question) {
        return repos.save(question);
    }

    @Override
    public Optional<Question> findById(Long id) {
        return repos.findById(id);
    }

    @Override
    public void removeById(Long id) {
        repos.deleteById(id);
    }

    @Override
    public Question editQuestion(QuestionDTO dto) {
        Question question = new Question(dto);
        question.setId(dto.getId());

        question.setStatusQuestion(new StatusQuestion(Long.parseLong(dto.getStatusQuestion())));
        return question;
    }
}
