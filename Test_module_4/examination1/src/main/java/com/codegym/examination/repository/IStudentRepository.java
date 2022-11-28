package com.codegym.examination.repository;

import com.codegym.examination.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Integer> {
    @Query(value = "select * from student s where s.title like concat('%',:title,'%')",
            nativeQuery = true ,
            countQuery = "select count(*) from (select * from student s where s.title like concat('%',:title,'%')) student")
    Page<Student> findAllByName(@Param("title") String content, Pageable page);
}
