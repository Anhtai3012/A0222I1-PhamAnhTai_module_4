package com.codegym.furama.model.employee;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "education_degree")
@Data
@ToString
public class EducationDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(45)",nullable = false)
    private String name;

    public EducationDegree() {
    }
}
