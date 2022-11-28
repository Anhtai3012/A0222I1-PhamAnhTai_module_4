package com.codegym.furama.model.employee;

import com.codegym.furama.model.employee.roles.User;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "employee")
@Data
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(45)",nullable = false)
    private String name;

    @Column(nullable = false)
    private Date date_of_birth;

    @Column(columnDefinition = "varchar(45)",nullable = false)
    private String id_card;

    private Double salary;

    @Column(columnDefinition = "varchar(45)",nullable = false)
    private String phone_number;

    @Column(columnDefinition = "varchar(45)",nullable = false)
    private String email;

    @Column(columnDefinition = "varchar(45)",nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "position_id",nullable = false,foreignKey = @ForeignKey(name = "id"))
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id",nullable = false,foreignKey = @ForeignKey(name = "id"))
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id",nullable = false,foreignKey = @ForeignKey(name = "id"))
    private Division division;

//    @ManyToOne
//    @JoinColumn(name = "username",nullable = false,foreignKey = @ForeignKey(name = "username"))
//    private User user;
    @Column(name = "username",nullable = false,columnDefinition = "varchar(50)")
    private String user;

    public Employee() {
    }
}
