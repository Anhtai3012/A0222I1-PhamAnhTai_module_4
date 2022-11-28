package com.codegym.examination.service.impl;

import com.codegym.examination.model.Student;
import com.codegym.examination.repository.IStudentRepository;
import com.codegym.examination.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public Page<Student> findAllByName(String keyword, Pageable pageable) {
        return studentRepository.findAllByName(keyword,pageable);
    }

    @Override
    public Optional<Student> findById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void removeID(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findAll() {
        return null;
    }
}
