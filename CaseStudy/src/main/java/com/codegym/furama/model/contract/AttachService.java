package com.codegym.furama.model.contract;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "attach_facility")
@Data
@ToString
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(45)",nullable = false)
    private String name;

    private Double cost;

    @Column(columnDefinition = "varchar(10)",nullable = false)
    private String unit;

    @Column(columnDefinition = "varchar(45)",nullable = false)
    private String status;

    public AttachService() {
    }
}
