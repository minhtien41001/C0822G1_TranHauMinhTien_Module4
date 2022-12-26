package com.example.casestudy_spring.service.customer;


import com.example.casestudy_spring.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
