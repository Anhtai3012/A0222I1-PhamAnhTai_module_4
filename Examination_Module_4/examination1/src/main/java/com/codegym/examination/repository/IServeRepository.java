package com.codegym.examination.repository;

import com.codegym.examination.model.Serve;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IServeRepository extends JpaRepository<Serve,Integer> {
    @Query(value = "select * from giao_dich g where g.service_type like concat('%',:content,'%')",
            nativeQuery = true ,
            countQuery = "select count(*) from (select * from giao_dich p where p.service_type like concat('%',:content,'%')) giao_dich")
    Page<Serve> findAllByName(@Param("content") String content,Pageable page);

//    @Query("select s from giao_dich s where s.customer.name like concat('%','','%')")
//    Page<Serve> findAllByCondition();
//
//    Page<Serve> findAllByCustomerName(String name);
}
