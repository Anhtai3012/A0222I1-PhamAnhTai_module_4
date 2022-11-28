package com.codegym.furama.model.contract;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.employee.Employee;
import com.codegym.furama.model.service.MainService;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.Set;

@Entity(name = "contract")
@AllArgsConstructor @NoArgsConstructor @Setter @Getter
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date start_date;

    private Date end_date;

    private Double deposit;

    @Column(name = "total_money")
    Double total_money;

    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false,referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false,referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id",nullable = false,referencedColumnName = "id")
    private MainService mainService;

    @OneToMany(mappedBy = "contract")
    @JsonBackReference
    private Set<ContractDetail> contractDetailSet;

}
