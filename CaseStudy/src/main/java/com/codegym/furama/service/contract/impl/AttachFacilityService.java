package com.codegym.furama.service.contract.impl;

import com.codegym.furama.model.contract.AttachService;
import com.codegym.furama.repository.contract.IAttachServiceRepository;
import com.codegym.furama.service.contract.IAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AttachFacilityService implements IAttachService {

    @Autowired
    private IAttachServiceRepository attachServiceRepository;
    @Override
    public Page<AttachService> findAllByName(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<AttachService> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(AttachService attachService) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
