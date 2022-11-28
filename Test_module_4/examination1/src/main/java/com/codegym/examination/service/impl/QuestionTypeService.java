package com.codegym.examination.service.impl;

import com.codegym.examination.model.QuestionType;
import com.codegym.examination.repository.IQuestionTypeRepository;
import com.codegym.examination.service.IQuestionTypeService;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionTypeService implements IQuestionTypeService {

    @Autowired
    private IQuestionTypeRepository questionTypeRepository;
    @Override
    public Page<QuestionType> findAllByName(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<QuestionType> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(QuestionType questionType) {

    }

    @Override
    public void removeID(Integer id) {

    }

    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }
}
