package com.codegym.examination.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "question_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuestionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "questionType")
    private List<Student> students;

    public QuestionType(Integer id){
        this.id=id;
    }

}
