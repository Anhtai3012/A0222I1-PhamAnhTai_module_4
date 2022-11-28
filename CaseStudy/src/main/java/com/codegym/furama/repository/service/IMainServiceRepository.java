package com.codegym.furama.repository.service;

import com.codegym.furama.model.employee.Employee;
import com.codegym.furama.model.service.MainService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IMainServiceRepository extends JpaRepository<MainService,Integer> {
    @Query(value = "select * from service s where s.name like concat('%',:name,'%') ",
            nativeQuery = true ,
            countQuery = "select count(*) from (select * from service s where s.name like concat('%',:name,'%')) service")
    Page<MainService> findAllByName(@Param("name") String name, Pageable page);
}
