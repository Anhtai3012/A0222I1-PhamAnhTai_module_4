package com.codegym.furama.service.employee.impl;

import com.codegym.furama.model.employee.EducationDegree;
import com.codegym.furama.model.employee.Employee;
import com.codegym.furama.repository.employee.EducationDegreeRepository;
import com.codegym.furama.service.employee.IEducationDegreeService;
import com.codegym.furama.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationDegreeService implements IEducationDegreeService {

    @Autowired
    private EducationDegreeRepository educationDegreeRepository;

    @Override
    public Page<EducationDegree> findAllByName(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<EducationDegree> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(EducationDegree educationDegree) {
        educationDegreeRepository.save(educationDegree);
    }

    @Override
    public void remove(Integer id) {
        educationDegreeRepository.deleteById(id);
    }

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
