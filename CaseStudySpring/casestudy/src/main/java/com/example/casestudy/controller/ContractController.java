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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;

    @Autowired
    private IContractDetailService iContractDetailService;

    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IEmployeeService iEmployeeService;


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

    @PostMapping("/add-contract-detail")
    public String saveDetail(@ModelAttribute ContractDetail contractDetail, RedirectAttributes redirectAttributes) {
        iContractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("message", "Thêm mới hợp đồng chi tiết thành công!");

        return "redirect:/contract";
    }

    @GetMapping("/{id}")
    public String showAttachFacility(@PathVariable Integer id, Model model) {
        model.addAttribute("contractDetails", iContractDetailService.showAll(id));

        return "contract/attachFacilityList";
    }
}
