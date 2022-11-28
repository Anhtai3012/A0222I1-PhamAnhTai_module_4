package com.codegym.furama.model.customer;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@Table(name = "customer")
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   @ManyToOne
   @JoinColumn(name = "type_customer_id",nullable = false, referencedColumnName = "id")
    private CustomerType customerType;

   @Column(columnDefinition = "varchar(50)")
   private String name;

   private Date date_of_birthday;

   private String id_card;

   private Boolean gender;

   @Column(columnDefinition = "varchar(50)")
   private String phone_number;

   @Column(columnDefinition = "varchar(50)")
    private  String email;

   @Column(columnDefinition = "varchar(50)")
    private String address;

    public Customer() {
    }

}
