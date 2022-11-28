package com.codegym.furama.service.contract.impl;

import com.codegym.furama.model.contract.Contract;
import com.codegym.furama.repository.contract.IContractRepository;
import com.codegym.furama.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;
    @Override
    public Page<Contract> findAllByName(String keyword, Pageable pageable) {
        return contractRepository.findAllByName(keyword,pageable);
    }

    @Override
    public Optional<Contract> findById(Integer id) {
        return contractRepository.findById(id);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(Integer id) {
        contractRepository.deleteById(id);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void updateMoneyById(Integer id) {
        contractRepository.updateMoneyById(id);
    }
}
