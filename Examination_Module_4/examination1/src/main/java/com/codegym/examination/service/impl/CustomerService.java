package com.codegym.examination.service.impl;

import com.codegym.examination.model.Customer;
import com.codegym.examination.repository.ICustomerRepository;
import com.codegym.examination.service.IBaseService;
import com.codegym.examination.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAllByName(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void removeID(Integer id) {

    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
