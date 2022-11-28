package com.codegym.examination.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;

@Entity(name = "giao_dich")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Serve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Pattern(regexp = "^(MGD)-[\\d]{4}$",message = "sai dinh dang")
    @NotBlank(message = "ko dc de trong")
    private String code;

    @FutureOrPresent
    private Date date;

    @NotBlank(message = "ko dc de trong")
    private String service_type;

    @NotNull(message = "ko dc de trong")
    @Min(value = 500,message = "gia phai lon hon 500 VND")
    private Double price;

    @Min(value = 20,message = "dien tich phai lon hon 20 m^2")
    @NotNull(message = "ko dc de trong")
    private Double area;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false,referencedColumnName = "id")
    private Customer customer;
}
