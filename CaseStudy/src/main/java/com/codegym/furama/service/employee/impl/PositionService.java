package com.codegym.furama.service.employee.impl;

import com.codegym.furama.model.employee.Position;
import com.codegym.furama.repository.employee.PositionRepository;
import com.codegym.furama.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PositionService implements IPositionService {

    @Autowired
    private PositionRepository positionRepository;
    @Override
    public Page<Position> findAllByName(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Position> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Position position) {
        positionRepository.save(position);
    }

    @Override
    public void remove(Integer id) {
        positionRepository.deleteById(id);
    }

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
