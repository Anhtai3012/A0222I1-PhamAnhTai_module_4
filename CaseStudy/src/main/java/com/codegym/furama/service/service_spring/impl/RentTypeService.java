package com.codegym.furama.service.service_spring.impl;

import com.codegym.furama.model.service.RentType;
import com.codegym.furama.repository.service.IRentTypeRepository;
import com.codegym.furama.service.service_spring.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RentTypeService implements IRentTypeService {

    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public Page<RentType> findAllByName(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<RentType> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(RentType rentType) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
