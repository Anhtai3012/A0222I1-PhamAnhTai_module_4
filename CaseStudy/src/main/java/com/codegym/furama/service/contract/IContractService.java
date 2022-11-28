package com.codegym.furama.service.contract;

import com.codegym.furama.model.contract.Contract;
import com.codegym.furama.service.IBaseService;

public interface IContractService extends IBaseService<Contract> {
    void updateMoneyById( Integer id);
}
