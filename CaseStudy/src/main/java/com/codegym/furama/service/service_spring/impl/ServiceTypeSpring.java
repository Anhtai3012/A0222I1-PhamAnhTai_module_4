package com.codegym.furama.service.service_spring.impl;

import com.codegym.furama.model.service.ServiceType;
import com.codegym.furama.repository.service.IServiceTypeRepository;
import com.codegym.furama.service.service_spring.IServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ServiceTypeSpring implements IServiceType {

    @Autowired
    private IServiceTypeRepository serviceTypeRepository;

    @Override
    public Page<ServiceType> findAllByName(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<ServiceType> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(ServiceType serviceType) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
