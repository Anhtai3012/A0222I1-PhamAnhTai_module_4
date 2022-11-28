package com.codegym.furama.repository.contract;

import com.codegym.furama.model.contract.Contract;
import com.codegym.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value = "select * from contract",
            nativeQuery = true ,
            countQuery = "select count(*) from contract")
    Page<Contract> findAllByName(@Param("name") String name, Pageable page);

    @Modifying
    @Transactional
    @Query(value = "update contract set total_money = total_money_service(:id) where id = :id", nativeQuery = true)
    void updateMoneyById(@Param("id") Integer id);
}
