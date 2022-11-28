package com.codegym.furama.model.employee.roles;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_role", uniqueConstraints = {
        @UniqueConstraint(name = "USER_ROLE_UK", columnNames = { "role_id", "username" }) })
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "role_id",nullable = false,foreignKey = @ForeignKey(name = "role_id"))
    private Role role;


    @ManyToOne
    @JoinColumn(name ="username",nullable = false,foreignKey = @ForeignKey(name = "username"))
    private User user;

    public UserRole() {
    }
}
