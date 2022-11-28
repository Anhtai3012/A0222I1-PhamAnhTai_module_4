package com.codegym.furama.dto;

import com.codegym.furama.model.contract.Contract;
import com.codegym.furama.utils.ConverterSetToStringHtml;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Data
@ToString
public class ContractDTO {
    Integer id;

    @FutureOrPresent
    Date start_date;

    Date end_date;

    @Min(0)
    Double deposit;

    @Min(0)
    Double total_money;

    @NotBlank
    String customer;

    String employee;

    String mainService;

    String listContractDetails;

    public ContractDTO(Contract contract) {
        id = contract.getId();
        start_date = contract.getStart_date();
        end_date = contract.getEnd_date();
        deposit = contract.getDeposit();
        total_money = contract.getTotal_money();
        employee = contract.getEmployee().getName();
        customer = contract.getCustomer().getName();
        mainService = contract.getMainService().getName();
        listContractDetails = ConverterSetToStringHtml.converterTable(contract.getContractDetailSet());
    }
}
