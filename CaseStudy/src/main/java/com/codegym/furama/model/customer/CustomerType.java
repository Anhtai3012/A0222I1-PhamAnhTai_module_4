package com.codegym.furama.model.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Table(name = "customer_type")
@ToString
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name",nullable = false,columnDefinition = "VARCHAR(50)")
    private String name;

    @OneToMany(mappedBy = "customerType")
    List<Customer> customerList;

    public CustomerType() {
    }
}
