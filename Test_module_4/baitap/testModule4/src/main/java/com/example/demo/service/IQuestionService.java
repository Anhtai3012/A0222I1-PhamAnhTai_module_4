package com.example.demo.service;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IQuestionService {
    Page<Question> findAllByTitleAndType(String title, String type, Pageable pageable);

    Question save(Question question);

    Optional<Question> findById(Long id)  ;

    void removeById(Long id);

    Question editQuestion(QuestionDTO dto);
}
