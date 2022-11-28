package com.example.demo.model;

import com.example.demo.dto.QuestionDTO;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "question")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    String content;

    String answer;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false, referencedColumnName = "id")
    TypeQuestion typeQuestion;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false, referencedColumnName = "id")
    StatusQuestion statusQuestion;

    Date date_create;

    public Question(QuestionDTO questionDTO) {
        this(null,
                questionDTO.getTitle(),
                questionDTO.getContent(),
                questionDTO.getAnswer(),
                new TypeQuestion(Long.parseLong(questionDTO.getTypeQuestion())),
                new StatusQuestion(1L),
                Date.valueOf(LocalDate.now()));
    }
}
