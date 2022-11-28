package com.codegym.furama.repository.employee;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.employee.Division;
import com.codegym.furama.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "select * from employee e where e.name like concat('%',:name,'%') ",
            nativeQuery = true ,
            countQuery = "select count(*) from (select * from employee e where e.name like concat('%',:name,'%')) employee")
    Page<Employee> findAllByName(@Param("name") String name, Pageable page);
}
