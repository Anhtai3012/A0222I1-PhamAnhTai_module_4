package com.codegym.furama.controller;

import com.codegym.furama.model.contract.AttachService;
import com.codegym.furama.model.contract.Contract;
import com.codegym.furama.model.contract.ContractDetail;
import com.codegym.furama.service.contract.IAttachService;
import com.codegym.furama.service.contract.IContractDetailService;
import com.codegym.furama.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/contract")
public class ControlAPIContract {

    @Autowired
    private IAttachService attachService;

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IContractService contractService;

    @ModelAttribute("attachServices")
    public List<AttachService> attachServices(){
        return attachService.findAll();
    }

    @ModelAttribute("contractDetails")
    public List<ContractDetail> contractDetails(){
        return contractDetailService.findAll();
    }

    @GetMapping("")
    public ResponseEntity<List<Contract>> list(){
        List<Contract> contractIterator =contractService.findAll();
        if (contractIterator.isEmpty())  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Contract>>(HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> create(@RequestBody Contract contract){
        contractService.save(contract);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contract> edit(@PathVariable("id") Integer id ,@RequestBody Contract contract){
        Optional<Contract> contract1 = contractService.findById(id);
        if (!contract1.isPresent())return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        contract.setId(contract1.get().getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Contract> delete(@PathVariable("id") Integer id){
        contractService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
