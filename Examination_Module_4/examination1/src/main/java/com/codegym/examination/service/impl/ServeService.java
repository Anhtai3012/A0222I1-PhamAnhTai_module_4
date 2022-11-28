package com.codegym.examination.service.impl;

import com.codegym.examination.model.Serve;
import com.codegym.examination.repository.IServeRepository;
import com.codegym.examination.service.IServeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ServeService implements IServeService {

    @Autowired
    private IServeRepository serveRepository;

    @Override
    public Page<Serve> findAllByName(String keyword, Pageable pageable) {
        return serveRepository.findAllByName(keyword,pageable);
    }

    @Override
    public Optional<Serve> findById(Integer id) {
        return serveRepository.findById(id);
    }

    @Override
    public void save(Serve serve) {
        serveRepository.save(serve);
    }

    @Override
    public void removeID(Integer id) {
        serveRepository.deleteById(id);
    }

    @Override
    public List<Serve> findAll() {
        return serveRepository.findAll();
    }
}
