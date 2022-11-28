package com.codegym.furama.model.employee.roles;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @Column(nullable = false,columnDefinition = "varchar(45)")
    private String username;

    @Column(nullable = false)
    private String password;


    public User() {
    }
}
