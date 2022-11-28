package com.codegym.furama.service.service_spring.impl;

import com.codegym.furama.model.service.MainService;
import com.codegym.furama.repository.service.IMainServiceRepository;
import com.codegym.furama.service.service_spring.IMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MainServiceSpring implements IMainService {

    @Autowired
    private IMainServiceRepository mainServiceRepository;

    @Override
    public Page<MainService> findAllByName(String keyword, Pageable pageable) {
        return mainServiceRepository.findAllByName(keyword,pageable);
    }

    @Override
    public Optional<MainService> findById(Integer id) {
        return mainServiceRepository.findById(id);
    }

    @Override
    public void save(MainService mainService) {
        mainServiceRepository.save(mainService);
    }

    @Override
    public void remove(Integer id) {
        mainServiceRepository.deleteById(id);
    }

    @Override
    public List<MainService> findAll() {
        return mainServiceRepository.findAll();
    }
}
