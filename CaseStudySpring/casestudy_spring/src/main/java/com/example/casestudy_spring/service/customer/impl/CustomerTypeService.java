package com.example.casestudy_spring.service.customer.impl;

import com.example.casestudy_spring.model.customer.CustomerType;
import com.example.casestudy_spring.repository.customer.ICustomerTypeRepository;
import com.example.casestudy_spring.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }
}
