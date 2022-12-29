package com.example.casestudy.controller;

import com.example.casestudy.dto.FacilityDto;
import com.example.casestudy.model.facility.Facility;
import com.example.casestudy.service.IFacilityService;
import com.example.casestudy.service.IFacilityTypeService;
import com.example.casestudy.service.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    IFacilityService iFacilityService;

    @Autowired
    IFacilityTypeService iFacilityTypeService;

    @Autowired
    IRentTypeService iRentTypeService;

    @GetMapping("/list")
    public String showList(@PageableDefault(value = 5)Pageable pageable,
                           @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                           @RequestParam(value = "facilityType", defaultValue = "")String facilityType,
                           Model model){
        model.addAttribute("listFacility",iFacilityService.searchFacility1(nameSearch, facilityType, pageable));
        model.addAttribute("listFacilityType",iFacilityTypeService.findAll());
        model.addAttribute("listRenType",iRentTypeService.findAll());
        model.addAttribute("nameSearch",nameSearch);
        model.addAttribute("facilityType",facilityType);
        return "facility/list";
    }

    @GetMapping("/create")
    public String createFacility(Model model){
        model.addAttribute("facilityDto",new FacilityDto());
        model.addAttribute("listFacilityType",iFacilityTypeService.findAll());
        model.addAttribute("listRentType",iRentTypeService.findAll());
        return "facility/create";
    }

    @PostMapping("/save")
    public String saveFacility(@Validated @ModelAttribute FacilityDto facilityDto,
                               BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "facility/create";
        }else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto,facility);
            iFacilityService.save(facility);
            return "redirect:/facility/list";
        }
    }

    @GetMapping("/edit/{id}")
    public String editFacility(@PathVariable int id,Model model){
        model.addAttribute("facilityDto",iFacilityService.findById(id));
        model.addAttribute("listFacilityType",iFacilityTypeService.findAll());
        model.addAttribute("listRentType",iRentTypeService.findAll());
        return "facility/edit";
    }

    @PostMapping("/update")
    public String updateFacility(@Validated @ModelAttribute FacilityDto facilityDto,BindingResult bindingResult,Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("listFacilityType",iFacilityTypeService.findAll());
            model.addAttribute("listRentType",iRentTypeService.findAll());
            return "facility/edit";
        }else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto,facility);
            iFacilityService.save(facility);
            return "redirect:/facility/list";
        }
    }

    @GetMapping("/delete")
    public String deleteFacility(@RequestParam(value = "idDelete") int id){
        iFacilityService.remove(id);
        return "redirect:/facility/list";
    }
}
