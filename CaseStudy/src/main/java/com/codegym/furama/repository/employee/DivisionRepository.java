package com.codegym.furama.repository.employee;

import com.codegym.furama.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository extends JpaRepository<Division,Integer> {
}
