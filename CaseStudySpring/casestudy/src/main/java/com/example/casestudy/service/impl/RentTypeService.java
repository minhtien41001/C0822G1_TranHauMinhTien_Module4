package com.example.casestudy.service.impl;

import com.example.casestudy.model.facility.RentType;
import com.example.casestudy.repository.facility.IRentTypeRepository;
import com.example.casestudy.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    IRentTypeRepository iRentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }
}
