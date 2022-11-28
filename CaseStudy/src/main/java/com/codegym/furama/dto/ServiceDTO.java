package com.codegym.furama.dto;

import com.codegym.furama.model.service.RentType;
import com.codegym.furama.model.service.ServiceType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
@Getter
@Setter

public class ServiceDTO {
    private Integer id;

    private String name;

    @Min(value = 20,message = "ko dc nho hon 20")
    private Integer area;

    @Min(value = 100,message = "ko dc nho hon 100")
    private Double service_cost;

    @Min(value = 1,message = "toi thieu it nhat 1 nguoi")
    private Integer max_people;

    private Integer rentType;

    private Integer serviceType;


    private String standard_room;

    private String description_other_convenience;

    private Double pool_area;

    private Integer number_of_floors;

    private String facility_text;

    public ServiceDTO() {
    }
}
