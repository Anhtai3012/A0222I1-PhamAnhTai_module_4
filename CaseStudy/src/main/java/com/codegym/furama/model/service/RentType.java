package com.codegym.furama.model.service;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity(name = "rent_type")
@ToString
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(45)",nullable = false)
    private String name;

    public RentType() {
    }

    public RentType(Integer id) {
        this.id = id;
    }
}
