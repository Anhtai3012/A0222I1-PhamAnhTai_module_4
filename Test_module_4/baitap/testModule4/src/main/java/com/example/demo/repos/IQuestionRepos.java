package com.example.demo.repos;

import com.example.demo.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepos extends JpaRepository<Question, Long> {
    @Query(value = "select * from question where title like concat ('%',:title,'%') and type_id like concat ('%',:type,'%') order by status_id asc, date_create desc",
            nativeQuery = true,
            countQuery = "select count(*) from (select * from Question q where title like concat('%',:title,'%') and type_id like concat('%',:type,'%')) q ")
    Page<Question> findAllByTitleAndType(@Param("title") String title, @Param("type") String type, Pageable pageable);

}
