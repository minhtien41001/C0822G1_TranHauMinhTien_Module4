package com.example.casestudy.controller;

import com.example.casestudy.model.contract.Contract;
import com.example.casestudy.model.contract.ContractDetail;
import com.example.casestudy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IContractService iContractService;

    @Autowired
    IContractDetailService iContractDetailService;

    @Autowired
    IAttachFacilityService iAttachFacilityService;

    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    IFacilityService iFacilityService;

    @Autowired
    IEmployeeService iEmployeeService;


    @GetMapping("/list")
    public String showList(@PageableDefault(value = 5   )Pageable pageable,
                           Model model){
        model.addAttribute("listContract",iContractService.findAllDto(pageable));
        model.addAttribute("listAttachFacility",iAttachFacilityService.findAll());
        model.addAttribute("listContractDetail",iContractDetailService.findAll());
        model.addAttribute("listCustomer",iCustomerService.findAll());
        model.addAttribute("listEmployee",iEmployeeService.findAll());
        model.addAttribute("listFacility",iFacilityService.findAll());
        model.addAttribute("contract",new Contract());
        model.addAttribute("contractDetail", new ContractDetail());
        return "contract/list";
    }

    @PostMapping("/create")
    public String saveContract(@ModelAttribute Contract contract){
        iContractService.save(contract);
        return "redirect:/contract/list";
    }
}
