package com.codegym.furama.service.contract.impl;

import com.codegym.furama.model.contract.ContractDetail;
import com.codegym.furama.repository.contract.IContractDetailRepository;
import com.codegym.furama.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private IContractDetailRepository contractDetailRepository;
    @Override
    public Page<ContractDetail> findAllByName(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<ContractDetail> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(ContractDetail contractDetail) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }
}
