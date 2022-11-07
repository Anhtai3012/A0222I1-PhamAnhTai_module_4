package com.codegym.blog.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@ToString(includeFieldNames = false)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    @Column(columnDefinition = "varchar(50)" , nullable = false)
    private String firstName;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String lastName;


    @OneToMany(mappedBy = "user")
    @Column(nullable = false)
    private List<Blog> blogs;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
