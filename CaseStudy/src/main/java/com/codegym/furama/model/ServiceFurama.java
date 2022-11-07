package com.codegym.furama.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class ServiceFurama {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_service")
    private String serviceName;

    @Column(name = "area")
    private Double area;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "max_people")
    private Integer maxPeople;

    @ManyToOne
    @JoinColumn(name = "rent_type_id")
    private TypeOfServiceFurama typeOfServiceFurama;

    public ServiceFurama() {
    }
}
