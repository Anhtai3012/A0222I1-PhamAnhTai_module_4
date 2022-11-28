package com.codegym.examination.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Entity(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "not empty")
    @Column(name = "title",nullable = false)
    private String title;

    @NotBlank(message = "not empty")
    @Column(nullable = false)
    private String content;


    @NotBlank(message = "not empty")
    @Column(nullable = false)
    private String answer;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_question_type",nullable = false,foreignKey = @ForeignKey(name = "id"))
    private QuestionType questionType;
}
