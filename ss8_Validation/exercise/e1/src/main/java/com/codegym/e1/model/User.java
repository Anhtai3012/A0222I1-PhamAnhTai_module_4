package com.codegym.e1.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 45,min = 5,message = "Size not match")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Size(max = 45,min = 5,message = "Size not match")
    @Column(name = "last_name")
    private String lastName;

    @Pattern(regexp = "^(\\\\+84|0)\\\\d{9}$", message = "Phone number is not exist")
    private String phone;

    @Min(value = 18, message = "you large than 18 year old")
    private Integer age;

    @Email
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9]+@gmail.com$",message = "email is not exist")
    private String email;

    public User() {
    }

    public User(Integer id, String firstName, String lastName, String phone, Integer age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
