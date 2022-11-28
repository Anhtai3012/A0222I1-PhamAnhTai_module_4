package com.codegym.furama.model.service;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "service")
@Data
@ToString
public class MainService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "ko dc de trong")
    @Column(nullable = false,columnDefinition = "varchar(45)")
    private String name;

    @NotNull(message = "ko dc de trong")
    @Min(value = 20,message = "ko dc nho hon 20")
    private Integer area;

    @NotNull(message = "ko dc de trong")
    @Min(value = 100,message = "ko dc nho hon 100")
    private Double service_cost;

    @NotNull(message = "ko dc de trong")
    @Min(value = 1,message = "toi thieu it nhat 1 nguoi")
    private Integer max_people;

    @ManyToOne
    @JoinColumn(name = "rent_type_id",nullable = false,foreignKey = @ForeignKey(name = "id"))
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id",nullable = false,referencedColumnName = "id")
    private ServiceType serviceType;

    @Column(nullable = false,columnDefinition = "varchar(45)")
    private String standard_room;

    @Column(nullable = false,columnDefinition = "varchar(45)")
    private String description_other_convenience;

    private Double pool_area;

    private Integer number_of_floors;

    private String facility_text;

    public MainService() {
    }
}
