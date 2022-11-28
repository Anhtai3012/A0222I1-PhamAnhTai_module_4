package com.codegym.furama.repository.employee;

import com.codegym.furama.model.employee.Division;
import com.codegym.furama.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position,Integer> {
}
