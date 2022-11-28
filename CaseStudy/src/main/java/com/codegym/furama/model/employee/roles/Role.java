package com.codegym.furama.model.employee.roles;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer role_id;

    @Column(nullable = false,columnDefinition = "varchar(45)")
    private String role_name;


    public Role() {
    }
}
