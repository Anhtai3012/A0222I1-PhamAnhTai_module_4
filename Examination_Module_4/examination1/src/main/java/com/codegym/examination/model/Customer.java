package com.codegym.examination.model;

import com.codegym.examination.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.time.LocalDate;

@Entity(name = "khach_hang")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String name;

    private Integer phone_number;

    private String email;

    public Customer(Integer id) {
        this.id = id;
    }

    public Customer(CustomerDTO c) {
        this.id = null;
        this.code = "HTVV";
//        this.birthday= Date.valueOf(LocalDate.now());
        this.name = c.getName();
        this.phone_number = c.getPhone_number();
        this.email = c.getEmail();
    }
}
