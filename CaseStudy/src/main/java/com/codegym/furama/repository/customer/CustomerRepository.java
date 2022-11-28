package com.codegym.furama.repository.customer;

import com.codegym.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select * from customer c where c.name like concat('%',:name,'%') ",
            nativeQuery = true ,
            countQuery = "select count(*) from (select * from customer c where c.name like concat('%',:name,'%')) customer")
    Page<Customer> findAllByName(@Param("name") String name, Pageable page);
}
