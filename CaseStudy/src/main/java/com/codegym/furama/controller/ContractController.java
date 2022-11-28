package com.codegym.furama.controller;

import com.codegym.furama.dto.ContractDTO;
import com.codegym.furama.model.contract.AttachService;
import com.codegym.furama.model.contract.Contract;
import com.codegym.furama.model.contract.ContractDetail;
import com.codegym.furama.service.contract.IAttachService;
import com.codegym.furama.service.contract.IContractDetailService;
import com.codegym.furama.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/contract")
public class ContractController {
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
    public String list(Model model,@RequestParam(value = "name", defaultValue = "") String name,
                       @PageableDefault(size = 3, sort = "start_date", direction = Sort.Direction.ASC) Pageable pageable){
        Page<Contract> contracts = contractService.findAllByName(name,pageable);
        model.addAttribute("list",converterDataToDTO(contracts));
        model.addAttribute("page_max",contracts.getTotalPages());
        model.addAttribute("name_search",name);
        return "contract/list";
    }

    @GetMapping("delete")
    public String delete(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","successful");
        contractService.remove(id);
        return "redirect:/contract";
    }

    private List<ContractDTO> converterDataToDTO(Page<Contract> list) {
        List<ContractDTO> result = new ArrayList<>();
        for (Contract contract : list) {
            result.add(new ContractDTO(contract));
        }
        return result;
    }

    @PostMapping("/api/save")
    public ResponseEntity<Void> createAPI(@RequestBody ContractDetail contractDetail){
        contractService.updateMoneyById(contractDetail.getContract().getId());
        return  new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
