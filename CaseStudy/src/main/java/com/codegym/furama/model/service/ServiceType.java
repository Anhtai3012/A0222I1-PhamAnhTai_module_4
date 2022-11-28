package com.codegym.furama.model.service;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "service_type")
@Data
@ToString
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(45)", nullable = false)
    private String name;

    public ServiceType() {
    }

    public ServiceType(Integer id) {
        this.id = id;
    }
}
