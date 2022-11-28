package com.codegym.furama.service.employee.impl;

import com.codegym.furama.model.employee.Division;
import com.codegym.furama.repository.employee.DivisionRepository;
import com.codegym.furama.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DivisionService implements IDivisionService {

    @Autowired
    private DivisionRepository divisionRepository;
    @Override
    public Page<Division> findAllByName(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Division> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Division division) {
        divisionRepository.save(division);
    }

    @Override
    public void remove(Integer id) {
        divisionRepository.deleteById(id);
    }

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
