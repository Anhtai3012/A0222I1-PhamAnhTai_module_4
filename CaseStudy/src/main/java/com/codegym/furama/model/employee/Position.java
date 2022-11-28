package com.codegym.furama.model.employee;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "position")
@Data
@ToString
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(45)",nullable = false)
    private String name;

    public Position() {
    }
}
