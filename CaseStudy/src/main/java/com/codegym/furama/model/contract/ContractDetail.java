package com.codegym.furama.model.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity(name = "contract_detail")
@AllArgsConstructor @NoArgsConstructor @Setter @Getter
@ToString
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "contract_id",nullable = false,foreignKey = @ForeignKey(name = "id"))
    @JsonBackReference
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attach_service_id",nullable = false,foreignKey = @ForeignKey(name = "id"))
    private AttachService attachService;

    private Integer quantity;
}
