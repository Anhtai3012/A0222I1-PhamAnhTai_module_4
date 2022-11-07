package com.codegym.furama.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class TypeOfServiceFurama {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeOfServiceFId;

    @Column(name = "type_of_service_Name")
    private String typeOfServiceFName;

    @OneToMany(mappedBy = "typeOfServiceFurama")
    private List<ServiceFurama> serviceFuramas;

    public TypeOfServiceFurama() {
    }
}
