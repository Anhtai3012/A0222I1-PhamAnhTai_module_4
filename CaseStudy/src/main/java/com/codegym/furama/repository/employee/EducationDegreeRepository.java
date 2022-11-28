package com.codegym.furama.repository.employee;

import com.codegym.furama.model.employee.Division;
import com.codegym.furama.model.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationDegreeRepository extends JpaRepository<EducationDegree,Integer> {
}
