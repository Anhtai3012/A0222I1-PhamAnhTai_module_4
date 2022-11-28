package com.codegym.furama.service.customer.impl;

import com.codegym.furama.model.customer.CustomerType;
import com.codegym.furama.repository.customer.ICustomerTypeRepository;
import com.codegym.furama.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public Page<CustomerType> findAllByName(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<CustomerType> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(CustomerType customerType) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
